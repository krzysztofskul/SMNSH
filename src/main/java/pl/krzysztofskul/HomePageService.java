package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.device.category.DeviceCategoryService;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.order.guideline.GuidelineService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.project.StatusProject;
import pl.krzysztofskul.questionnaire.*;
import pl.krzysztofskul.questionnaire.questionSet.*;
import pl.krzysztofskul.recipient.Recipient;
import pl.krzysztofskul.recipient.RecipientService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.avatar.AvatarService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class HomePageService {

    /**
     * params.
     */
    private UserService userService;
    private DeviceCategoryService deviceCategoryService;
    private DeviceService deviceService;
    private ConceptService conceptService;
    private QuestionFormService questionFormService;
    private QuestionSetForXRAYService questionSetForXRAYService;
    private QuestionSetForCTService questionSetForCTService;
    private QuestionSetForMRIService questionSetForMRIService;
    private GuidelineService guidelineService;
    private InvestorService investorService;
    private RecipientService recipientService;
    private ProjectService projectService;
    private AvatarService avatarService;

    /** constr.
     *
     */
    @Autowired
    public HomePageService(
            UserService userService,
            DeviceCategoryService deviceCategoryService,
            DeviceService deviceService,
            ConceptService conceptService,
            QuestionFormService questionFormService,
            QuestionSetForXRAYService questionSetForXRAYService,
            QuestionSetForCTService questionSetForCTService,
            QuestionSetForMRIService questionSetForMRIService,
            GuidelineService guidelineService,
            InvestorService investorService,
            RecipientService recipientService,
            ProjectService projectService,
            AvatarService avatarService
    ) {
        this.userService = userService;
        this.deviceCategoryService = deviceCategoryService;
        this.deviceService = deviceService;
        this.conceptService = conceptService;
        this.questionFormService = questionFormService;
        this.questionSetForXRAYService = questionSetForXRAYService;
        this.questionSetForCTService = questionSetForCTService;
        this.questionSetForMRIService = questionSetForMRIService;
        this.guidelineService = guidelineService;
        this.investorService = investorService;
        this.recipientService = recipientService;
        this.projectService = projectService;
        this.avatarService = avatarService;
    }

    /** methods
     *
     */

    public void createUsers() {
        /** create 2 users at planner business position */
        for (int i = 1; i <= 2; i++) {
            User user = new User();
            user.setNameFirst("Name"+i);
            user.setNameLast("Surname"+i);
            user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
            user.setPassword("test");
            user.setPasswordConfirmation(user.getPassword());
            user.setBusinessPosition(UserBusinessPosition.PLANNER);
            userService.save(user);
        }
        /** create 6 users at project manager business position */
        for (int i = 3; i <= 9; i++) {
            User user = new User();
            user.setNameFirst("Name"+i);
            user.setNameLast("Surname"+i);
            user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
            user.setPassword("test");
            user.setPasswordConfirmation(user.getPassword());
            user.setBusinessPosition(UserBusinessPosition.PROJECT_MANAGER);
            userService.save(user);
        }
        /** create guest/admin */
        User user = new User();
        user.setNameFirst("Nameguest");
        user.setNameLast("Surname-Admin");
        user.setEmail("Nameguest.Surname-Admin@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.ADMIN);
        userService.save(user);

        //todo: user's avatar
        /** save avatar for 1st user */
        /* load File */
        //todo?: del / convert File to MultiPartFile
        //File file = new File("/resources/img/avatars/avatar-01_128x128px.png");
        /* convert File to MultipartFile */

        /* save MultipartFile to DB*/
        //avatarService.save(multipartFile);

        //byte[] byteFile = new byte[(int) file.length()];
        //try {
        //    FileInputStream fileInputStream = new FileInputStream(file);
        //    /* convert file into array of bytes */
        //    fileInputStream.read(byteFile);
        //    fileInputStream.close();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        /* create Avatar from loaded file */
        //Avatar avatar = new Avatar();
        //avatar.setData(byteFile);
        /* save avatar to DB */
        //avatarService.save(avatar);
        /* connect avatar to user */
        //userService.loadById(Long.parseLong("1")).setAvatar(avatar);
    }

    public void createRealTestUsers() {
        User user;
        /** NEW USER : ADMIN */
        user = new User();
        user.setNameFirst("Piotr");
        user.setNameLast("W.");
        user.setEmail("piotr.w@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.ADMIN);
        userService.save(user);
        /** NEW USER : PROJECT MANAGER */
        user = new User();
        user.setNameFirst("Sebastian");
        user.setNameLast("K.");
        user.setEmail("sebastian.k@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.PROJECT_MANAGER);
        userService.save(user);
        /** NEW USER : PROJECT MANAGER */
        user = new User();
        user.setNameFirst("Ewa");
        user.setNameLast("W-M.");
        user.setEmail("ewa.w-m@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.PROJECT_MANAGER);
        userService.save(user);
        /** NEW USER : DESIGNER */
        user = new User();
        user.setNameFirst("Krzysztof");
        user.setNameLast("K.");
        user.setEmail("krzysztof.k@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.PLANNER);
        userService.save(user);
        /** NEW USER : DESIGNER */
        user = new User();
        user.setNameFirst("Maciej");
        user.setNameLast("D.");
        user.setEmail("maciej.d@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.PLANNER);
        userService.save(user);
    }

    public void createInvestors() {
        for (int i = 1; i <= 9; i++) {
            Investor investor = new Investor();
            investor.setName("Investor no. "+i);
            investorService.save(investor);
        }
    }

    public void createRealTestInvestors() {
        Investor investor;

        investor = new Investor();
        investor.setName("Szpital Centralny w Warszawie");
        investorService.save(investor);

        investor = new Investor();
        investor.setName("Szpital Powiatowy w Otwocku");
        investorService.save(investor);

        investor = new Investor();
        investor.setName("Szpital Kliniczny w Krakowie");
        investorService.save(investor);

    }

    public void createRecipients() {
        for (int i = 1; i <= 9; i++) {
            Recipient recipient = new Recipient();
            recipient.setDepartment("Department "+i);
            recipientService.save(recipient);
        }
    }

    public void createRealTestRecipients() {
        Recipient recipient;

        recipient = new Recipient();
        recipient.setDepartment("Oddział diagnostyki obrazowej");
        recipientService.save(recipient);

        recipient = new Recipient();
        recipient.setDepartment("Szpitalny oddział ratunkowy");
        recipientService.save(recipient);

    }

    public void createConcepts() {
        /** create one concept for first six users */
        for (int i = 1; i <= 6; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(i))));
            concept.setDescription("Lorem ipsum dolor sit amet mi eget sapien. Aliquam quis tortor. Cras volutpat ligula enim.");
            concept.setRemarks("Phasellus vitae ante. Duis non.");
            concept.setDevice(deviceService.loadById(Long.parseLong("1")));

            QuestionForm questionForm = new QuestionForm();
            QuestionSetForXRAY questionSetForXRAY = new QuestionSetForXRAY();

            questionForm.setQuestionSetForXRAY(questionSetForXRAY);
            questionSetForXRAY.setQuestionForm(questionForm);
            questionForm.setConcept(concept);
            concept.setQuestionForm(questionForm);

            concept.setPriority("!");
            conceptService.save(concept);

            questionSetForXRAY.setXrayProtectionToDesign(new Random().nextBoolean());
            questionSetForXRAY.setSourceImageDistanceRequired(new Random().nextInt(200));

            questionForm =questionFormService.loadById(questionSetForXRAY.getQuestionForm().getId());
            questionSetForXRAY.setQuestionForm(questionForm);
            questionSetForXRAYService.save(questionSetForXRAY);

            /** change dates of creation */
            concept = conceptService.loadById(Long.parseLong(String.valueOf(i)));
            concept.setDateTimeCreated(LocalDateTime.now().minusDays(31-i));
            concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
            concept.setStatus(Status.IN_PROGRESS);
            concept.setPlanner(userService.loadById(Long.parseLong("1")));
            conceptService.save(concept);
        }
        /** create additional concepts to first two users */
        for (int i = 7; i <= 8; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(1))));
            concept.setDescription("Drogi Marszałku, Wysoka Izbo. PKB rośnie. Różnorakie i rozwijanie struktur umożliwia w restrukturyzacji przedsiębiorstwa. Jednakże.");
            concept.setRemarks("Izbo, inwestowanie w większym stopniu.");
            concept.setDevice(deviceService.loadById(Long.parseLong("4")));

            QuestionForm questionForm = new QuestionForm();
            QuestionSetForCT questionSetForCT = new QuestionSetForCT();

            questionForm.setQuestionSetForCT(questionSetForCT);
            questionSetForCT.setQuestionForm(questionForm);
            questionForm.setConcept(concept);
            concept.setQuestionForm(questionForm);

            concept.setPriority("!");
            concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
            conceptService.save(concept);

            questionSetForCT.setXrayProtectionToDesign(new Random().nextBoolean());

            questionForm =questionFormService.loadById(questionSetForCT.getQuestionForm().getId());
            questionSetForCT.setQuestionForm(questionForm);
            questionSetForCTService.save(questionSetForCT);

        }
        for (int i = 9; i <= 9; i++) {
            Concept concept = new Concept();
            concept.setTitle("Concept title no. " + i);
            concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(2))));
            concept.setDescription("Początek traktatu czasu panowania Fryderyka Wielkiego, Króla Pruskiego żył w.");
            concept.setRemarks("Na przykład w kolei przypadków.");
            concept.setDevice(deviceService.loadById(Long.parseLong("7")));

            QuestionForm questionForm = new QuestionForm();
            QuestionSetForMRI questionSetForMRI = new QuestionSetForMRI();

            questionForm.setQuestionSetForMRI(questionSetForMRI);
            questionSetForMRI.setQuestionForm(questionForm);
            questionForm.setConcept(concept);
            concept.setQuestionForm(questionForm);
            
            concept.setPriority("!");
            concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
            conceptService.save(concept);

            questionSetForMRI.setFaradayCageToDesign(new Random().nextBoolean());

            questionForm =questionFormService.loadById(questionSetForMRI.getQuestionForm().getId());
            questionSetForMRI.setQuestionForm(questionForm);
            questionSetForMRIService.save(questionSetForMRI);
            
        }
    }

    public void createGuidelines() {
        /** create guidelines order fot first two users */
        for (int i = 1; i <= 2; i++) {
            Guideline guideline = new Guideline();
            guideline.setAuthor(userService.loadById(Long.parseLong(String.valueOf(i))));
            guideline.setTitle("Guidelines order");
            guideline.setConcept(conceptService.loadById(Long.parseLong(String.valueOf(i))));
            guideline.setStatus(Status.ORDERED_WAITING);
            guideline.setPriority("!!!");
            guideline.setDateTimeDeadline(LocalDateTime.now().plusDays(14+2*i));
            guideline.setPersonAccepting("Dr X");
            guideline.setDateOfAcceptation(LocalDate.now().minusDays(2));
            guidelineService.save(guideline);
        }
    }

    public void createDeviceCategories() {
        DeviceCategory deviceCategory;

        deviceCategory = new DeviceCategory();
        deviceCategory.setCode("MRI");
        deviceCategory.setName("Magnetic resonance imaging system");
        deviceCategoryService.save(deviceCategory);

        deviceCategory = new DeviceCategory();
        deviceCategory.setCode("X-RAY");
        deviceCategory.setName("X-Ray imaging system");
        deviceCategoryService.save(deviceCategory);

        deviceCategory = new DeviceCategory();
        deviceCategory.setCode("CT");
        deviceCategory.setName("Computed tomography system");
        deviceCategoryService.save(deviceCategory);

    }

    public void createDevices() {
        for (int i = 1; i <= 3; i++) {
            Device device = new Device();
            device.setModel("X-Ray device / model "+i);
            device.setDeviceCategory(deviceCategoryService.loadByCode("X-RAY"));
            deviceService.save(device);
        }
        for (int i = 4; i <= 6; i++) {
            Device device = new Device();
            device.setModel("CT device / model "+(i-3));
            device.setDeviceCategory(deviceCategoryService.loadByCode("CT"));
            deviceService.save(device);
        }
        for (int i = 7; i <= 9; i++) {
            Device device = new Device();
            device.setModel("MRI device / model "+(i-6));
            device.setDeviceCategory(deviceCategoryService.loadByCode("MRI"));
            deviceService.save(device);
        }
    }

    public void createRealTestDevices() {
        Device device;

        device = new Device();
        device.setModel("Lorem");
        device.setDeviceCategory(deviceCategoryService.loadByCode("X-RAY"));
        deviceService.save(device);

        device = new Device();
        device.setModel("Ipsum");
        device.setDeviceCategory(deviceCategoryService.loadByCode("X-RAY"));
        deviceService.save(device);

        device = new Device();
        device.setModel("Etiam");
        device.setDeviceCategory(deviceCategoryService.loadByCode("CT"));
        deviceService.save(device);

        device = new Device();
        device.setModel("Suspendisse");
        device.setDeviceCategory(deviceCategoryService.loadByCode("CT"));
        deviceService.save(device);

        device = new Device();
        device.setModel("Curabitur");
        device.setDeviceCategory(deviceCategoryService.loadByCode("MRI"));
        deviceService.save(device);

        device = new Device();
        device.setModel("Vestibulum");
        device.setDeviceCategory(deviceCategoryService.loadByCode("MRI"));
        deviceService.save(device);

    }

    public void createProjects() {
        for (int i = 1; i <= 2; i++) {
            Project project = new Project();
            project.setProjectName("Test project no. "+i);
            project.setAgreementNo("AGR-NO-WAW-00"+i+"-2020");
            project.setDeadline(LocalDateTime.now().plusDays(Long.parseLong("28")));
            project.setStatus(StatusProject.STATUS_PROJECT_0);
            List<Device> deviceList = new ArrayList<>();
            deviceList.add(deviceService.loadById(Long.valueOf("1")+i));
            deviceList.add(deviceService.loadById(Long.valueOf("4")+i));
            project.setDeviceList(deviceList);
            project.setBuildingContractor("BC GmbH & Co. KG");
            project.setInvestor("MED Investor Sp. z o.o.");
            project.setRecipient("City Hospital, Diagnostic Dep., Room "+i+"00, Room "+i+"20");
            project.setSls("Sales Rep. name and surname");
            project.setProjectManager(userService.loadById(Long.valueOf("3")+i));
            project.setRemarks("Lorem ipsum. Lorem ipsum dolor sit amet leo. Suspendisse potenti. Suspend fringilla mi, viverra et, porttitor sem nec diam. Phasellus a mauris. Pellentesque scelerisque rhoncus tortor. In hac habitasse plate dictumst.");
            projectService.save(project);
        }
    }
}