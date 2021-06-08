package pl.krzysztofskul;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.krzysztofskul.company.type.CompanyTypeService;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.category.DeviceCategoryService;
import pl.krzysztofskul.device.part.Part;
import pl.krzysztofskul.device.part.PartService;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.order.guideline.GuidelineService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.project.comment.CommentService;
import pl.krzysztofskul.project.configuration.Configuration;
import pl.krzysztofskul.project.configuration.ConfigurationService;
import pl.krzysztofskul.questionnaire.QuestionFormService;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForCTService;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForMRIService;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForXRAYService;
import pl.krzysztofskul.recipient.RecipientService;
import pl.krzysztofskul.subcontractor.SubcontractorService;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.avatar.AvatarService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class HomePageServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private HomePageService homePageService;
    @Autowired
    private CompanyTypeService companyTypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private DeviceCategoryService deviceCategoryService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ConceptService conceptService;
    @Autowired
    private QuestionFormService questionFormService;
    @Autowired
    private QuestionSetForXRAYService questionSetForXRAYService;
    @Autowired
    private QuestionSetForCTService questionSetForCTService;
    @Autowired
    private QuestionSetForMRIService questionSetForMRIService;
    @Autowired
    private GuidelineService guidelineService;
    @Autowired
    private InvestorService investorService;
    @Autowired
    private RecipientService recipientService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AvatarService avatarService;
    @Autowired
    private LoggerUserService<Object> loggerUserService;
    @Autowired
    private LoggerProjectService<Object> loggerProjectService;
    @Autowired
    private SubcontractorService subcontractorService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PartService partService;
    @Autowired
    private ConfigurationService configurationService;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
//    public void whenCreateConfigurations_shouldBeSavedToDb() {
    public void test1() {

        companyTypeService.createCompanyTypesAndSaveToDB();
        subcontractorService.createTestSubcontractors();
        investorService.createTestInvestors(15);
        homePageService.createRealTestUsers();
        homePageService.createUsers();
        homePageService.createDeviceCategories();
        homePageService.createDevices();
        homePageService.createRealTestDevices();
        homePageService.createParts();
        homePageService.createConcepts();
        homePageService.createGuidelines();
        homePageService.createInvestors();
        homePageService.createRealTestInvestors();
        homePageService.createRecipients();
        homePageService.createRealTestRecipients();
        homePageService.createProjects();

        List<Configuration> configurationList = configurationService.loadAll();
        assertTrue(configurationList != null && configurationList.size() > 0);

    }

    @Test
//    public void whenCreateConfigurations_shouldProjectsBeRelatedWithConfigurations() {
    public void test2() {

        List<Project> projectList = projectService.loadAllWithConfigurationList();
        boolean isAnyConfigurationSavedToProject = false;
        for (Project project : projectList) {
            if (project.getConfigurationList() != null && project.getConfigurationList().size() > 0) {
                isAnyConfigurationSavedToProject = true;
            }
            assertTrue(isAnyConfigurationSavedToProject);
        }
    }

    @Test
    //    public void whenCreateConfigurations_shouldBeRelatedInDB()
    public void test3() {
        List<Project> projectList = projectService.loadAllWithConfigurationList();
        for (Project project : projectList) {
            for (Configuration configuration : project.getConfigurationList()) {
                assertNotNull(configuration.getDevice());
                assertNotNull(configuration.getProject());
                configuration = configurationService.loadByIdWithParts(configuration.getId());
                assertTrue(configuration.getPartList().size() > 0);
            }
        }
    }

}