package pl.krzysztofskul.stakeholder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	
	
	
}
