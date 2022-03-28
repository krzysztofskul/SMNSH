package pl.krzysztofskul.stakeholder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
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
import pl.krzysztofskul.company.type.CompanyTypeService;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.initDB.InitDB;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.projectCharter.ProjectCharterService;
import pl.krzysztofskul.subcontractor.SubcontractorService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class StakeholderServiceTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Autowired
	private StakeholderService stakeholderService;
	@Autowired
	private UserService userService;
	@Autowired
	private HomePageService homePageService;
	@Autowired
	private CompanyTypeService companyTypeService;
	@Autowired
	private SubcontractorService subcontractorService;
	@Autowired
	private InvestorService investorService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectCharterService projectCharterService;
	@Autowired
	private DeviceService deviceService;

	private static User userTestSls = new User();
	private static Project projectTest;
	private static Stakeholder stakeholderFromUserTest;
	
	@Test
	@Order(value = 1)
	// public Stakeholder createAndGetInitTestStakeholderFromUser(User user) {}
	public void givenStakeholderFromUser_whenSaveToDb_shouldReturnStakeholderCorrectly() {
		
		// given
		homePageService.initTestDb();
		userTestSls.setNameFirst(LoremIpsum.getInstance().getFirstName());
		userTestSls.setNameLast(LoremIpsum.getInstance().getLastName());
		userTestSls.setBusinessPosition(UserBusinessPosition.SALES_REP);
		userTestSls = userService.saveAndReturn(userTestSls);
		stakeholderFromUserTest = stakeholderService.createAndGetInitTestStakeholderFromUser(userTestSls);
		
		// when
		stakeholderFromUserTest = stakeholderService.saveStakeholder(stakeholderFromUserTest);
		
		// should
		assertTrue(stakeholderFromUserTest.getId() != null);
		assertTrue(stakeholderFromUserTest.getId() > 0);
		assertTrue(stakeholderFromUserTest.getNameFirst().equals(userTestSls.getNameFirst()));
		assertTrue(stakeholderFromUserTest.getNameLast().equals(userTestSls.getNameLast()));
		assertTrue(stakeholderFromUserTest.getStakeholderBusinessPosition().equals(userTestSls.getBusinessPosition().toString()));

	}
	
	@Test
	@Order(value = 2)
	public void testUserTestSls() {
		assertTrue(StakeholderServiceTest.userTestSls.getId() != null && StakeholderServiceTest.userTestSls.getId() > 0);
	}
	
	@Test
	@Order(value = 3)
	// public void addStakeholderFromUserToProject (Stakeholder stakeholder, Project project)
	public void givenProjectAndStekholderFromUser_whenAddStakeholderFromUserToProject_shouldSaveToDbCorrectly() {
		// given	
		homePageService.initTestDb();		
		projectTest = projectService.loadById((long) new Random().nextInt(projectService.loadAll().size())+1);
		stakeholderFromUserTest = stakeholderService.loadStakeholderById(stakeholderFromUserTest.getId());
		
		assertTrue(projectTest.getId() != null && projectTest.getId() > 0);
		assertTrue(stakeholderFromUserTest.getId() != null && stakeholderFromUserTest.getId() > 0);
		
		// when
		stakeholderService.addStakeholderFromUserToProject(stakeholderFromUserTest.getId(), projectTest.getProjectCharter().getId());
		
		// should
		assertTrue(
				stakeholderService.loadStakeholderInProjectDetailsById(stakeholderFromUserTest.getId())
					.getStakeholder().getId()
					.equals(stakeholderFromUserTest.getId())
		);

		assertTrue(
				projectCharterService.loadByIdWithStakeholders(projectTest.getProjectCharter().getId()).getStakeholders() != null
				);
		

		assertTrue(
				projectCharterService.loadByIdWithStakeholders(projectTest.getProjectCharter().getId()).getStakeholders().size() > 0
				);

		/*
		 * todo 2022-03-28
		 */
		
//		assertTrue(
//				projectService.loadByIdWithStakeholders(projectTest.getId()).getProjectCharter()
//				.getStakeholders().stream()
//						.filter(
//							s -> s.getId().equals(stakeholderFromUserTest.getId())
//						).findAny().orElseThrow().equals(stakeholderFromUserTest.getId())
//		);
//		
		
		
	}
}
