package pl.krzysztofskul.projectCharter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.HomePageService;
import pl.krzysztofskul.initDB.InitDbForTests;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.milestone.Milestone;
import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.MilestoneSingleton;
import pl.krzysztofskul.project.milestone.MilestoneTemplate;
import pl.krzysztofskul.project.milestone.service.MilestoneService;
import pl.krzysztofskul.stakeholder.Stakeholder;
import pl.krzysztofskul.stakeholder.StakeholderInProjectDetails;
import pl.krzysztofskul.stakeholder.StakeholderService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ProjectCharterServiceTest {

	private static boolean initializedDB = false;
	
	@Autowired
	private HomePageService homePageService;
	
	@Autowired
	private InitDbForTests initDbForTests;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StakeholderService stakeholderService;
	
	@Autowired
	private ProjectCharterService projectCharterService;
	
	@Autowired
	private MilestoneService milestoneService;
	
	private void initDB() {
		if (ProjectCharterServiceTest.initializedDB == false) {
			
			// create and save to DB project charters
			for (int i = 1; i <= MilestoneSingleton.getMilestoneSingleton().getMilestoneTemplates().size(); i++) {
				projectCharterService.save(new ProjectCharter());
			}
			// create and save to DB milestone templates
			for (Milestone milestone : MilestoneSingleton.getMilestoneSingleton().getMilestoneTemplates()) {
				milestoneService.saveMilestone(milestone);
			}
		
			ProjectCharterServiceTest.initializedDB = true;
			
		}
		
		
	}
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    	initDB();
	}
	
	@Test
	@Order(value = 1)
	public void givenListOfProjectsChartersAndMilestonesTemplates_whenAddMilestoneTemplatesToProjectsCharters_shouldBeSavedToDbCorrectly() {
		for (ProjectCharter projectCharter : projectCharterService.loadAllWithMilestoneInstanceList()) {
			for (MilestoneTemplate milestoneTemplate : milestoneService.loadAllMilestoneTemplateList()) {
				projectCharterService.addMilestoneInstanceFromTemplates(projectCharter.getId(), milestoneTemplate.getId());
				projectCharterService.save(projectCharter);
			}
		}
	}
	
	@Test
	@Order(value = 2)
	public void givenProjectCharters_whenLoadWithMilestonesFromDB_shouldBeLoadedCorrectly() {
		for (ProjectCharter projectCharter : projectCharterService.loadAllWithMilestoneInstanceList()) {
			assertTrue(projectCharter.getMilestoneInstanceList() != null && projectCharter.getMilestoneInstanceList().size() > 1);
			assertTrue(projectCharter.getMilestoneInstanceList().size() == MilestoneSingleton.getMilestoneSingleton().getMilestoneTemplates().size());
			assertTrue(milestoneService.loadAllMilestoneInstanceList().size() == projectCharterService.loadAll().size()*milestoneService.loadAllMilestoneTemplateList().size());
		}
	}
	
	@Test
	@Order(value = 3)
	public void givenProjectChareterWithMilestones_whenRemoveMilestone_shouldRemoveFromProjectCharterAndMilestoneInstanceFromDb() throws NoSuchElementException {
		for (ProjectCharter projectCharter : projectCharterService.loadAllWithMilestoneInstanceList()) {
			assertTrue(projectCharterService.loadAllWithMilestoneInstanceList().size() > 1);
			for (MilestoneInstance milestoneInstance : projectCharter.getMilestoneInstanceList()) {
				projectCharterService.removeMilestoneInstance(projectCharter.getId(), milestoneInstance.getId());
				try {
					milestoneService.loadMielestoneInstanceById(milestoneInstance.getId());
				} catch(NoSuchElementException ex) {
					assertNotNull(ex);
				}
			}
			assertTrue(projectCharterService.loadByIdWithMilestoneInstanceList(projectCharter.getId()).getMilestoneInstanceList().size() == 0);
		}
	}
	
	@Test
	@Order(value = 4)
	public void givenMilestoneInstanceAmdProjectCharter_whenAddMilestoneInstance_shouldBeAddedToDbCorrectly() {
		// given
		MilestoneInstance milestoneInstance = new MilestoneInstance();
		milestoneInstance = milestoneService.saveMilestoneInstance(milestoneInstance);
		ProjectCharter projectCharter = new ProjectCharter();
		projectCharter = projectCharterService.save(projectCharter);
		
		// when
		projectCharterService.addMilestoneInstance(projectCharter.getId(), milestoneInstance.getId());

		// should
		assertTrue(projectCharterService.loadByIdWithMilestoneInstanceList(projectCharter.getId()).getMilestoneInstanceList().size() == 1);
		assertTrue(milestoneService.loadMielestoneInstanceByIdWithProjectCharterList(milestoneInstance.getId()).getProjectCharterList().size() == 1);

	}
	
	@Test
	@Order(value = 5)
	public void givenProjectCharterAndStakeholders_whenAddStakholderDetailsToProjectCharetr_shouldBeSavedToDbCorretly() {
		// given
		homePageService.initTestDb();
		initDbForTests.createTestUsersAndStakeholders();
		ProjectCharter projectCharter = initDbForTests.getRandomProjectCharterWithStakeholderInProjectDetailsList();
		List<Stakeholder> stakeholderList = initDbForTests.getTestStakeholders();
		
		// when
		for (Stakeholder stakeholder : stakeholderList) {
			projectCharterService.addStakeholderInProjectDetailsToProjectCharter(
					new StakeholderInProjectDetails(stakeholder, "test role of stakeholder from user", "test description for stakholder from user"),
					projectCharter.getId()
			);
		}
		
		// should
		assertTrue(
				projectCharterService.loadByIdWithStakeholderInProjectDetailsList(projectCharter.getId()).getStakeholderInProjectDetailsList().size()
				==
				stakeholderList.size()
			);
	}
	
	@Test
	@Order(value = 6)
	public void givenProjectCharter_whenAddNewStakeholder_shouldBeSavedToDbCorrectly() {
		// given
		ProjectCharter projectCharter = initDbForTests.getRandomProjectCharterWithStakeholderInProjectDetailsList();
		Stakeholder newStakeholder = initDbForTests.createAndReturnNewTestStakeholder();
		
		// when
		projectCharterService.addStakeholderInProjectDetailsToProjectCharter(new StakeholderInProjectDetails(newStakeholder, "test role of new stakeholder", "test description for new stakeholder"), projectCharter.getId());
		
		// should
		assertTrue(projectCharterService.loadByIdWithStakeholderInProjectDetailsList(projectCharter.getId()).getStakeholderInProjectDetailsList().size() 
				>
				projectCharter.getStakeholderInProjectDetailsList().size()
				);
	}
	

}
