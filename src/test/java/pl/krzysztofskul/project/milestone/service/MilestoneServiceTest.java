package pl.krzysztofskul.project.milestone.service;

import static org.junit.Assert.*;


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
import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.MilestoneSingleton;
import pl.krzysztofskul.project.milestone.MilestoneTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class MilestoneServiceTest {

	private static boolean initializedDB = false;
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Autowired
	private MilestoneService milestoneService;
	
	@Before
	public void initDB() {
		if (MilestoneServiceTest.initializedDB == false) {	
			// create milestone templates
			for (MilestoneTemplate milestoneTemplate : MilestoneSingleton.getMilestoneSingleton().getMilestoneTemplates()) {
				milestoneService.saveMilestone(milestoneTemplate);
			}
			// create milestone instances
			for (int i = 0; i < 3; i++) {
				MilestoneInstance milestoneInstance = new MilestoneInstance();
				milestoneService.saveMilestone(milestoneInstance);
			}
			MilestoneServiceTest.initializedDB = true;
		}
	}

	@Test
	@Order(value = 1)
	public void loadAllMilestoneTemplateList() {
		assertTrue(milestoneService.loadAllMilestoneTemplateList().size() > 0);
	}
	
	@Test
	@Order(value = 2)
	public void loadAllMilestoneInstanceList() {
		assertTrue(milestoneService.loadAllMilestoneInstanceList().size() > 0);
		assertTrue(milestoneService.loadMielestoneInstanceById(Long.parseLong("1")).getMilestoneTimeline().getId() == 1);
	}

}
