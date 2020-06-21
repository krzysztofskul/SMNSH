package pl.krzysztofskul.subcontractor;

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
import pl.krzysztofskul.company.type.CompanyTypeService;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class SubcontractorServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SubcontractorService subcontractorService;

    @Autowired
    private CompanyTypeService companyTypeService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void createTestSubcontractors() {
        companyTypeService.createCompanyTypesAndSaveToDB();
        subcontractorService.createTestSubcontractors();
        assertTrue(subcontractorService.loadAll().size() == 10);
        assertTrue(subcontractorService.loadAll().get(1).getQualityTypeEnum() != null);
    }
}