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
import pl.krzysztofskul.initDB.InitDbForTests;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.projectCharter.ProjectCharter;
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
	private InitDbForTests initDbForTests;
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
	
	@Test
	@Order(value = 1)
	/*
	 * method to test: createAndGetInitTestStakeholderFromUser(User user)
	 */
	public void givenStakeholderFromUser_whenSaveToDb_shouldReturnStakeholderCorrectly() {
		
		// given
		homePageService.initTestDb();
		initDbForTests.createTestUsersAndStakeholders();
		
		// when
		for (Stakeholder stakeholder : initDbForTests.stakeholderFromUserTestList) {
			stakeholder = stakeholderService.saveStakeholder(stakeholder);
		}
		
		// should
		assertTrue(initDbForTests.stakeholderFromUserTest1.getId() != null);
		assertTrue(initDbForTests.stakeholderFromUserTest1.getId() > 0);
		assertTrue(initDbForTests.stakeholderFromUserTest1.getNameFirst().equals(initDbForTests.userTestSls.getNameFirst()));
		assertTrue(initDbForTests.stakeholderFromUserTest1.getNameLast().equals(initDbForTests.userTestSls.getNameLast()));
		assertTrue(initDbForTests.stakeholderFromUserTest1.getStakeholderBusinessPosition().equals(initDbForTests.userTestSls.getBusinessPosition().toString()));

	}
	
	@Test
	@Order(value = 2)
	public void testUserTestSls() {
		assertTrue(initDbForTests.userTestSls.getId() != null && initDbForTests.userTestSls.getId() > 0);
	}
	
	@Test
	@Order(value = 3)
	/*
	 * method to test: addStakeholderFromUserToProject (...)
	 */
	public void givenProjectAndStekholdersFromUser_whenAddStakeholderFromUserToProject_shouldSaveToDbCorrectly() {
		// given	
		homePageService.initTestDb();		
		initDbForTests.projectTest = projectService.loadById((long) new Random().nextInt(projectService.loadAll().size())+1);
		initDbForTests.stakeholderFromUserTest1 = stakeholderService.loadStakeholderById(initDbForTests.stakeholderFromUserTest1.getId());
		
		assertTrue(initDbForTests.projectTest.getId() != null && initDbForTests.projectTest.getId() > 0);
		assertTrue(initDbForTests.stakeholderFromUserTest1.getId() != null && initDbForTests.stakeholderFromUserTest1.getId() > 0);
		
		// when
		for (Stakeholder stakeholder: initDbForTests.stakeholderFromUserTestList) {
			stakeholderService.addStakeholderFromUserToProject(stakeholder.getId(), initDbForTests.projectTest.getProjectCharter().getId());	
		}
		
		// should
		for (Stakeholder stakeholder : initDbForTests.stakeholderFromUserTestList) {
			assertTrue(
					stakeholderService.loadStakeholderInProjectDetailsById(stakeholder.getId())
						.getStakeholder().getId()
						.equals(stakeholder.getId())
			);			
		}

		assertTrue(
				projectCharterService.loadByIdWithStakeholders(initDbForTests.projectTest.getProjectCharter().getId()).getStakeholders() != null
				&&
				projectCharterService.loadByIdWithStakeholders(initDbForTests.projectTest.getProjectCharter().getId()).getStakeholders().size() == initDbForTests.stakeholderFromUserTestList.size()
				);
		
	}
}
