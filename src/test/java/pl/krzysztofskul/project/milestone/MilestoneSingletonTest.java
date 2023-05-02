package pl.krzysztofskul.project.milestone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.krzysztofskul.AppConfig;
import pl.krzysztofskul.project.milestone.Milestone;
import pl.krzysztofskul.project.milestone.MilestoneSingleton;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class MilestoneSingletonTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void testGetMilestoneTemplates() {
		List<MilestoneTemplate> milestonesTemplates = new ArrayList<>();
		milestonesTemplates = MilestoneSingleton.getMilestoneSingleton().getMilestoneTemplates();
		assertTrue(milestonesTemplates.size() > 0);
	}

	@Test
	public void testGetMilestoneSingleton() {
		assertTrue(MilestoneSingleton.getMilestoneSingleton() != null);
	}

}
