package pl.krzysztofskul.investor;

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
import pl.krzysztofskul.company.CompanyTypeService;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class InvestorServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Autowired
    private InvestorService investorService;

    @Autowired
    private CompanyTypeService companyTypeService;

    @Test
    public void whenCreateTestInvestors_shouldSaveAllToDB() {
        // given
        companyTypeService.createCompanyTypesAndSaveToDB();
        int i = 15;
        // when
        investorService.createTestInvestors(i);
        // should
        assertTrue(investorService.loadAll().size() == i);
        assertTrue(investorService.loadById(Long.parseLong("1")).getCompanyType() != null);
    }
}