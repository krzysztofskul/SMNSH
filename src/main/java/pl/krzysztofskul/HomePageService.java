package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.device.category.DeviceCategoryService;
import pl.krzysztofskul.device.part.Part;
import pl.krzysztofskul.device.part.PartDemoGenerator;
import pl.krzysztofskul.device.part.PartService;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.investor.creator.Creator;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.order.guideline.GuidelineService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.project.StatusProject;
import pl.krzysztofskul.project.comment.CommentService;
import pl.krzysztofskul.questionnaire.QuestionForm;
import pl.krzysztofskul.questionnaire.QuestionFormService;
import pl.krzysztofskul.questionnaire.questionSet.*;
import pl.krzysztofskul.recipient.Recipient;
import pl.krzysztofskul.recipient.RecipientService;
import pl.krzysztofskul.subcontractor.SubcontractorService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserAction;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.avatar.AvatarService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    private LoggerUserService<Object> loggerUserService;
    private LoggerProjectService<Object> loggerProjectService;
    private SubcontractorService subcontractorService;
    private CommentService commentService;
    private PartService partService;

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
            AvatarService avatarService,
            LoggerUserService<Object> loggerUserService,
            LoggerProjectService<Object> loggerProjectService,
            SubcontractorService subcontractorService, CommentService commentService, PartService partService) {
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
        this.loggerUserService = loggerUserService;
        this.loggerProjectService = loggerProjectService;
        this.subcontractorService = subcontractorService;
        this.commentService = commentService;
        this.partService = partService;
    }

    /** methods
     *
     */

    private String verifyEmail(User user) {
        List<User> userList = userService.loadAll();
        boolean isValid = true;
        do {
            int j = 2;
            for (User userExisted : userList) {
                if (userExisted.getEmail().equals(user.getEmail())) {
                    user.setEmail(user.getNameFirst()+user.getNameLast()+"-"+j+"@test.test");
                    isValid = false;
                    j++;
                } else {
                    isValid = true;
                }
            }
        } while (!isValid);
        return user.getEmail();
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
        user.setNameFirst("Maciej");
        user.setNameLast("D.");
        user.setEmail("maciej.d@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.PLANNER);
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
        /** NEW USER : SALES REP. */
        user = new User();
        user.setNameFirst("Wojciech");
        user.setNameLast("G.");
        user.setEmail("wojciech.g@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.SALES_REP);
        userService.save(user);
        /** NEW USER : SALES REP. */
        user = new User();
        user.setNameFirst("Ryszard");
        user.setNameLast("G.");
        user.setEmail("ryszard.g@test.test");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.SALES_REP);
        userService.save(user);
    }

    public void createUsers() {
        /** create guest/admin */
        User user = new User();
        user.setNameFirst("Admin");
        user.setNameLast("Administrator");
        user.setEmail("smnshapp@gmail.com");
        user.setPassword("test");
        user.setPasswordConfirmation(user.getPassword());
        user.setBusinessPosition(UserBusinessPosition.ADMIN);
        //userService.save(user);
        /** save avatar for 1st user */
//        Path path = Paths.get("http://localhost:8080/resources/img/avatars/img_avatar_businesswoman.jpg");

        /* ok */
//        URL res = getClass().getClassLoader().getResource("img/avatars/img_avatar_businesswoman.jpg");
//        try {
//            File file = Paths.get(res.toURI()).toFile();
//            String absPath = file.getAbsolutePath();
//            Avatar avatar = new Avatar();
//            avatar.setFileType("image/jpg");
//            avatar.setFileName(file.getName());
//            try {
//                avatar.setData(Files.readAllBytes(file.toPath()));
//                avatarService.save(avatar);
//                user.setAvatar(avatar);
//                userService.save(user);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        /* ok */
        /*Path path = Paths.get("/home/krzysztofskul/workspace/IdeaProjects/SMNSH/src/main/webapp/resources/img/avatars/img_avatar_businesswoman.png");
        Avatar avatar = new Avatar();
        avatar.setFileType("image/png");
        avatar.setFileName(path.toFile().getName());
        try {
            avatar.setData(Files.readAllBytes(path));
            avatarService.save(avatar);
            user.setAvatar(avatar);
            //userService.save(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            userService.save(user);
        }*/
        /** create 5 users at sales rep. position */
        for (int i = 1; i <= 5; i++) {
            user = new User();
//            user.setNameFirst(Creator.getCreator().getRandomNameMale());
//            user.setNameLast(Creator.getCreator().getRandomSurnameMale());
            user.setNameFirst("Jan");
//            user.setNameLast("Nowak-"+i);
            user.setNameLast("Nowak");
            user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
            user.setEmail(verifyEmail(user));
            user.setPassword("test");
            user.setPasswordConfirmation(user.getPassword());
            user.setBusinessPosition(UserBusinessPosition.SALES_REP);
            userService.save(user);
        }

        /** create 2 users at planner business position */
        for (int i = 1; i <= 2; i++) {
            user = new User();
//            user.setNameFirst("Name"+i);
//            user.setNameLast("Surname"+i);
            user.setNameFirst("Jan");
            user.setNameLast("Kowalski-"+i);
//            user.setNameFirst(Creator.getCreator().getRandomNameFemale());
//            user.setNameLast(Creator.getCreator().getRandomSurnameFemale());
            user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
            user.setPassword("test");
            user.setPasswordConfirmation(user.getPassword());
            user.setBusinessPosition(UserBusinessPosition.PLANNER);
            userService.save(user);
        }
        /** create 6 users at project manager business position */
        for (int i = 3; i <= 9; i++) {
            user = new User();
//            user.setNameFirst("Name"+i);
//            user.setNameLast("Surname"+i);
            user.setNameFirst("Janina");
            user.setNameLast("Nowak-"+i);
//            user.setNameFirst(Creator.getCreator().getRandomNameMale());
//            user.setNameLast(Creator.getCreator().getRandomSurnameMale());
            user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
            user.setPassword("test");
            user.setPasswordConfirmation(user.getPassword());
            user.setBusinessPosition(UserBusinessPosition.PROJECT_MANAGER);
            userService.save(user);
        }

    }

    public void createInvestors() {
        for (int i = 1; i <= 9; i++) {
            Investor investor = new Investor();
            investor.setName("Investor no. "+i);
            investor.setPostalCode(Creator.getCreator().getRandomPostalCode());
            investor.setCity(Creator.getCreator().getRandomCity());
            investor.setStreet(Creator.getCreator().getRandomStreet());
            investor.setNumber(new Random().nextInt(249)+1);
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

    public void createDevicesAndParts() {
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

        for (Part part : PartDemoGenerator.getPartDemoGenerator().getPartDemoList()) {
            partService.save(part);
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
            project.setSubcontractor(subcontractorService.loadById(
                    (long) new Random().nextInt(subcontractorService.loadAll().size())+1
            ));
//            project.setInvestor("MED Investor Sp. z o.o.");
            project.setInvestor(investorService.loadById(Long.parseLong(String.valueOf(i))));
            project.setRecipient("City Hospital, Diagnostic Dep., Room "+i+"00, Room "+i+"20");
            //project.setSls("Sales Rep. name and surname");
            project.setSls(userService.loadAllSalesReps().get(0));
            project.setProjectManager(userService.loadById(Long.valueOf("1")+i));
            project.setRemarks("Lorem ipsum. Lorem ipsum dolor sit amet leo. Suspendisse potenti. Suspend fringilla mi, viverra et, porttitor sem nec diam. Phasellus a mauris. Pellentesque scelerisque rhoncus tortor. In hac habitasse plate dictumst.");
            projectService.save(project);
            loggerUserService.log(project.getProjectManager(), LocalDateTime.now(), UserAction.PROJECT_CREATE, project);
            loggerProjectService.log(project,LocalDateTime.now(ZoneId.of("Europe/Warsaw")), "PROJECT CREATED", project.getProjectManager().getNameFirst()+" "+project.getProjectManager().getNameLast());
            project.setStatus(StatusProject.STATUS_PROJECT_9);
            projectService.save(project);
            loggerProjectService.log(project,LocalDateTime.now(ZoneId.of("Europe/Warsaw")), "PROJECT STATUS CHANGED", project.getProjectManager().getNameFirst()+" "+project.getProjectManager().getNameLast());
        }
        for (int i = 0; i <= 19; i++) {
            Project project = new Project();
            project.setProjectName("Test project no. "+i);
            project.setAgreementNo("AGR-NO-WAW-00"+i+"-2020");
            project.setDeadline(LocalDateTime.now().plusDays(new Random().nextInt(28)+1));
            if (i == 0 || i == 10) {
                project.setStatus(StatusProject.STATUS_PROJECT_0);
            }
            if (i == 1 || i == 11) {
                project.setStatus(StatusProject.STATUS_PROJECT_1);
            }
            if (i == 2 || i == 12) {
                project.setStatus(StatusProject.STATUS_PROJECT_2);
            }
            if (i == 3 || i == 13) {
                project.setStatus(StatusProject.STATUS_PROJECT_3);
            }
            if (i == 4 || i == 14) {
                project.setStatus(StatusProject.STATUS_PROJECT_4);
            }
            if (i == 5 || i == 15) {
                project.setStatus(StatusProject.STATUS_PROJECT_5);
            }
            if (i == 6 || i == 16) {
                project.setStatus(StatusProject.STATUS_PROJECT_6);
            }
            if (i == 7 || i == 17) {
                project.setStatus(StatusProject.STATUS_PROJECT_7);
            }
            if (i == 8 || i == 18) {
                project.setStatus(StatusProject.STATUS_PROJECT_8);
            }
            if (i == 9 || i == 19) {
                project.setStatus(StatusProject.STATUS_PROJECT_9);
            }
            List<Device> deviceList = new ArrayList<>();
            deviceList.add(deviceService.loadById((long) (new Random().nextInt(15) + 1)));
            deviceList.add(deviceService.loadById((long) (new Random().nextInt(15) + 1)));
            project.setDeviceList(deviceList);
            project.setBuildingContractor("BC GmbH & Co. KG");
            project.setSubcontractor(subcontractorService.loadById(
                    (long) new Random().nextInt(subcontractorService.loadAll().size())+1
            ));
//            project.setInvestor("MED Investor Sp. z o.o.");
            project.setInvestor(investorService.loadById(
                    (long) new Random().nextInt(
                        investorService.loadAll().size())+1
                    )
            );
            project.setRecipient("City Hospital, Diagnostic Dep., Room "+i+"00, Room "+i+"20");
            //project.setSls("Sales Rep. name and surname");
            project.setSls(userService.loadAllSalesReps().get(0));
            project.setProjectManager(userService.loadById(Long.valueOf("1")));
            project.setRemarks("Lorem ipsum. Lorem ipsum dolor sit amet leo. Suspendisse potenti. Suspend fringilla mi, viverra et, porttitor sem nec diam. Phasellus a mauris. Pellentesque scelerisque rhoncus tortor. In hac habitasse plate dictumst.");
            projectService.save(project);
            loggerUserService.log(project.getProjectManager(), LocalDateTime.now(), UserAction.PROJECT_CREATE, project);
        }
        commentService.createDemoComments();
    }
}