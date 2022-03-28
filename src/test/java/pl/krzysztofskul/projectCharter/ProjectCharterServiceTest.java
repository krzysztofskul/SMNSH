package pl.krzysztofskul.projectCharter;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

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

import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.project.milestone.Milestone;
import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.MilestoneSingleton;
import pl.krzysztofskul.project.milestone.MilestoneTemplate;
import pl.krzysztofskul.project.milestone.service.MilestoneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ProjectCharterServiceTest {

	private static boolean initializedDB = false;
	
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
	

}