package pl.krzysztofskul.project.configuration;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.HomePageService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfigurationServiceTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
		
	@Autowired
	private HomePageService homepageService;	
	@Autowired
	private ConfigurationService configurationService;	
	@Autowired
	private ProjectService projectService;
	
	@Test
	public void test01_LoadAllByProjectIdWithParts() {
		homepageService.initTestDb();
		List<Configuration> configurationList = configurationService.loadAllByProjectIdWithParts(
					(long) new Random().nextInt(projectService.loadAll().size()+1)
				);
		
		for (Configuration configuration : configurationList) {
			assertTrue(configuration.getId() != 0);
			assertTrue(configuration.getPartList().size() > 0);
		}
		
	}

}
