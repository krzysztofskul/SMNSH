package pl.krzysztofskul.device.part;

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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class PartServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Autowired
    private PartService partService;

    @Test
    public void whenGenerateDemoParts_shouldBeSavedInDB() {
        //given
        List<Part> partList = PartDemoGenerator.getPartDemoGenerator().getPartDemoList();
        //when
        for (Part part : partList) {
            assertEquals(partService.save(part).getClass(), Part.class);
        }
        //then
        assertNotNull(partService.loadAll());
        assertTrue(partService.loadAll().size() > 0);

    }

}