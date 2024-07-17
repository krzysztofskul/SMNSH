package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.attachment.AttachmentCategory;
import pl.krzysztofskul.attachment.AttachmentCategoryDefaultGenerator;
import pl.krzysztofskul.attachment.AttachmentCategoryService;
import pl.krzysztofskul.attachment.AttachmentService;
import pl.krzysztofskul.company.type.CompanyTypeService;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.device.category.DeviceCategoryService;
import pl.krzysztofskul.device.modality.ModalityService;
import pl.krzysztofskul.device.part.Part;
import pl.krzysztofskul.device.part.PartDemoGenerator;
import pl.krzysztofskul.device.part.PartService;
import pl.krzysztofskul.device.prototype.Prototype;
import pl.krzysztofskul.device.prototype.PrototypeService;
import pl.krzysztofskul.importdata.ImportData;
import pl.krzysztofskul.initDB.InitDB;
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
import pl.krzysztofskul.project.configuration.ConfigurationService;
import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.MilestoneSingleton;
import pl.krzysztofskul.project.milestone.MilestoneTemplate;
import pl.krzysztofskul.project.milestone.service.MilestoneService;
import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.projectCharter.ProjectCharterService;
import pl.krzysztofskul.questionnaire.QuestionForm;
import pl.krzysztofskul.questionnaire.QuestionFormService;
import pl.krzysztofskul.questionnaire.questionSet.*;
import pl.krzysztofskul.recipient.Recipient;
import pl.krzysztofskul.recipient.RecipientService;
import pl.krzysztofskul.smnsh4.Company.Company;
import pl.krzysztofskul.smnsh4.Company.CompanyService;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategory;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryEnum;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryRepo;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryService;
import pl.krzysztofskul.stakeholder.StakeholderService;
import pl.krzysztofskul.subcontractor.Subcontractor;
import pl.krzysztofskul.subcontractor.SubcontractorDemoGenerator;
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
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class HomePageService {

    /**
     * params.
     */
	private boolean isDeviceCategoriesCreated = false;
	
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
    private ConfigurationService configurationService;
    private MilestoneService milestoneService;
    private ProjectCharterService projectCharterService;
    private CompanyTypeService companyTypeService;
    private StakeholderService stakeholderService;
    private PrototypeService prototypeService;
    private AttachmentCategoryDefaultGenerator attachmentCategoryDefaultGenerator;
    private AttachmentCategoryService attachmentCategoryService;
    private SubcontractorDemoGenerator subcontractorDemoGenerator;
    private CompanyCategoryService companyCategoryService;
    private CompanyService companyService;
    private ModalityService modalityService;

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
            SubcontractorService subcontractorService, CommentService commentService, PartService partService, ConfigurationService configurationService,
            MilestoneService milestoneService,
            ProjectCharterService projectCharterService,
            CompanyTypeService companyTypeService,
            StakeholderService stakeholderService,
            PrototypeService prototypeService,
            AttachmentCategoryDefaultGenerator attachmentCategoryDefaultGenerator,
            AttachmentCategoryService attachmentCategoryService,
            SubcontractorDemoGenerator subcontractorDemoGenerator,
            CompanyCategoryService companyCategoryService,
            CompanyService companyService,
            ModalityService modalityService
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
        this.loggerUserService = loggerUserService;
        this.loggerProjectService = loggerProjectService;
        this.subcontractorService = subcontractorService;
        this.commentService = commentService;
        this.partService = partService;
        this.configurationService = configurationService;
        this.milestoneService = milestoneService;
        this.projectCharterService = projectCharterService;
        this.companyTypeService = companyTypeService;
        this.stakeholderService = stakeholderService;
        this.prototypeService = prototypeService;
        this.attachmentCategoryDefaultGenerator = attachmentCategoryDefaultGenerator;
        this.attachmentCategoryService = attachmentCategoryService;
        this.subcontractorDemoGenerator = subcontractorDemoGenerator;
        this.companyCategoryService = companyCategoryService;
        this.companyService = companyService;
        this.modalityService = modalityService;
    }

    /** methods
     *
     */

    public void initTestDb() {
		InitDB.getInstanceInitDB();
		if (InitDB.getCounter() == 0) {
			InitDB.increaseCounter();
			companyTypeService.createCompanyTypesAndSaveToDB();
			subcontractorService.createTestSubcontractors();
			investorService.createTestInvestors(15);
			userService.createRealTestUsersAndSaveToDb();
			stakeholderService.createDemoOuterCompanyStakeholderAndSaveToDb();
			this.createDeviceCategories();
			//this.createDevices();
			this.createRealTestDevices();
			this.createParts();
			//this.createConcepts();
			//this.createGuidelines();
			//this.createInvestors();
			this.createRealTestInvestors();
			//this.createRecipients();
			this.createRealTestRecipients();
			this.initializeMilestoneTemplatesToDb();;
			this.createProjects();
			this.createConcepts();
			//this.createGuidelines();
		}
    }
    
    private String verifyEmail(User user) {
        List<User> userList = userService.loadAll();
        boolean isValid = true;
        do {
            int j = 2;
            for (User userExisted : userList) {
            	if (null != userExisted.getEmail()) {
	                if (userExisted.getEmail().equals(user.getEmail())) {
	                    user.setEmail(user.getNameFirst()+user.getNameLast()+"-"+j+"@test.test");
	                    isValid = false;
	                    j++;
	                } else {
	                    isValid = true;
	                }
            	}
            }
        } while (!isValid);
        return user.getEmail();
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
        /*Path path = Paths.get("/home/krzysztofskul/workspace/IdeaProjects/smnsh2/src/main/webapp/resources/img/avatars/img_avatar_businesswoman.png");
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
        
        investor = new Investor();
        investor.setName("Szpital Wielospecjalistyczny we Wrocławiu");
        investorService.save(investor);        
        
        investor = new Investor();
        investor.setName("Szpital Miejski w Poznaniu");
        investorService.save(investor);

    }

    public void createRecipients() {
    	for (int i = 0; i < 9; i++) {
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
        //for (int i = 1; i <= 6; i++) {
    	for (Project project : projectService.loadAllWithDeviceList()) {
            Concept concept = new Concept();
            concept.setTitle("Concept demo title");
            concept.setAuthor(userService.loadById(project.getProjectManager().getId()));
            concept.setDescription("Lorem ipsum dolor sit amet mi eget sapien. Aliquam quis tortor. Cras volutpat ligula enim.");
            concept.setRemarks("Phasellus vitae ante. Duis non.");
            concept.setDevice(deviceService.loadById(project.getDeviceList().get(0).getId()));

            QuestionForm questionForm = new QuestionForm();
            QuestionSetForXRAY questionSetForXRAY = new QuestionSetForXRAY();

            questionForm.setQuestionSetForXRAY(questionSetForXRAY);
            questionSetForXRAY.setQuestionForm(questionForm);
            questionForm.setConcept(concept);
            concept.setQuestionForm(questionForm);

            concept.setPriority("!");
            concept.setProject(project);
            conceptService.save(concept);

            questionSetForXRAY.setXrayProtectionToDesign(new Random().nextBoolean());
            questionSetForXRAY.setSourceImageDistanceRequired(new Random().nextInt(200));

            questionForm =questionFormService.loadById(questionSetForXRAY.getQuestionForm().getId());
            questionSetForXRAY.setQuestionForm(questionForm);
            questionSetForXRAYService.save(questionSetForXRAY);

            /** change dates of creation */
            //concept = conceptService.loadById(Long.parseLong(String.valueOf(i)));
            //concept.setDateTimeCreated(LocalDateTime.now().minusDays(31-i));
            //concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
            //concept.setStatus(Status.IN_PROGRESS);
            //concept.setPlanner(userService.loadById(Long.parseLong("1")));
            //conceptService.save(concept);
        }
        /** create additional concepts to first two users */
		/*
		 * for (int i = 7; i <= 8; i++) { Concept concept = new Concept();
		 * concept.setTitle("Concept title no. " + i);
		 * concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(1))));
		 * concept.
		 * setDescription("Drogi Marszałku, Wysoka Izbo. PKB rośnie. Różnorakie i rozwijanie struktur umożliwia w restrukturyzacji przedsiębiorstwa. Jednakże."
		 * ); concept.setRemarks("Izbo, inwestowanie w większym stopniu.");
		 * concept.setDevice(deviceService.loadById(Long.parseLong("4")));
		 * 
		 * QuestionForm questionForm = new QuestionForm(); QuestionSetForCT
		 * questionSetForCT = new QuestionSetForCT();
		 * 
		 * questionForm.setQuestionSetForCT(questionSetForCT);
		 * questionSetForCT.setQuestionForm(questionForm);
		 * questionForm.setConcept(concept); concept.setQuestionForm(questionForm);
		 * 
		 * concept.setPriority("!");
		 * concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
		 * conceptService.save(concept);
		 * 
		 * questionSetForCT.setXrayProtectionToDesign(new Random().nextBoolean());
		 * 
		 * questionForm
		 * =questionFormService.loadById(questionSetForCT.getQuestionForm().getId());
		 * questionSetForCT.setQuestionForm(questionForm);
		 * questionSetForCTService.save(questionSetForCT);
		 * 
		 * } for (int i = 9; i <= 9; i++) { Concept concept = new Concept();
		 * concept.setTitle("Concept title no. " + i);
		 * concept.setAuthor(userService.loadById(Long.parseLong(String.valueOf(2))));
		 * concept.
		 * setDescription("Początek traktatu czasu panowania Fryderyka Wielkiego, Króla Pruskiego żył w."
		 * ); concept.setRemarks("Na przykład w kolei przypadków.");
		 * concept.setDevice(deviceService.loadById(Long.parseLong("7")));
		 * 
		 * QuestionForm questionForm = new QuestionForm(); QuestionSetForMRI
		 * questionSetForMRI = new QuestionSetForMRI();
		 * 
		 * questionForm.setQuestionSetForMRI(questionSetForMRI);
		 * questionSetForMRI.setQuestionForm(questionForm);
		 * questionForm.setConcept(concept); concept.setQuestionForm(questionForm);
		 * 
		 * concept.setPriority("!");
		 * concept.setDateTimeDeadline(LocalDateTime.now().plusDays(7+i));
		 * conceptService.save(concept);
		 * 
		 * questionSetForMRI.setFaradayCageToDesign(new Random().nextBoolean());
		 * 
		 * questionForm
		 * =questionFormService.loadById(questionSetForMRI.getQuestionForm().getId());
		 * questionSetForMRI.setQuestionForm(questionForm);
		 * questionSetForMRIService.save(questionSetForMRI);
		 * 
		 * }
		 */
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
    	
    	if (isDeviceCategoriesCreated == false) {    	
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
	        
	        isDeviceCategoriesCreated = true;
    	}

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

        for (int i = 0; i < 5; i++) {
            device = new Device();
            device.setModel(LoremIpsum.getInstance().getTitle(1));
            device.setDeviceCategory(deviceCategoryService.loadByCode("X-RAY"));
            deviceService.save(device);			
		}
        for (int i = 0; i < 5; i++) {
        	device = new Device();
        	device.setModel(LoremIpsum.getInstance().getTitle(1));
        	device.setDeviceCategory(deviceCategoryService.loadByCode("CT"));
        	deviceService.save(device);			
        }
        for (int i = 0; i < 5; i++) {
        	device = new Device();
        	device.setModel(LoremIpsum.getInstance().getTitle(1));
        	device.setDeviceCategory(deviceCategoryService.loadByCode("MRI"));
        	deviceService.save(device);			
        }
        
    }
    
    public void initializeMilestoneTemplatesToDb() {
        for (MilestoneTemplate milestoneTemplate : MilestoneSingleton.getMilestoneSingleton().getMilestoneTemplates()) {
    			milestoneService.saveMilestone(milestoneTemplate);
		}
    }

    public void createProjects() {
    	
    	/*
    	 * create demo projects for each sales rep., for each project manager and for each project status
    	 */
        for (User userSls : userService.loadAllSalesReps()) {
        	for (User userPm : userService.loadAllProjectManagers()) {
				for (StatusProject projectStatus : StatusProject.values()) {
					Project project = new Project("demo");
					project.setSls(userSls);
					project.setProjectManager(userPm);
					project.setStatus(projectStatus);
					//project.setInvestor(investorService.loadById((long) new Random().nextInt(investorService.loadAll().size())+1));
					//project.setSubcontractor(subcontractorService.loadById((long) new Random().nextInt(subcontractorService.loadAll().size())+1));
					for(int i = 0; i <= new Random().nextInt(3); i++) {
						project.addDevice(deviceService.loadById((long) new Random().nextInt(deviceService.loadAll().size())+1));					
					}
					projectService.save(project);
					
			        /*
			         * add default milestones (from template) to the project
			         */
			        List<MilestoneTemplate> milestoneTemplateList = milestoneService.loadAllMilestoneTemplateList();
			        for (MilestoneTemplate milestoneTemplate : milestoneTemplateList) {
						projectCharterService.addMilestoneInstanceFromTemplates(project.getId(), milestoneTemplate.getId());
					}
				}
        	}
		}
        
        /*
         *create demo comments 
         */
        commentService.createDemoComments();
        
        /*
         * add demo stakeholders to each project charter
         */
        for (ProjectCharter projectCharter : projectCharterService.loadAll()) {
			projectCharterService.setDemoStakeholders(projectCharter.getId());
		}
    }

    public void createParts() {
        for (Part part : PartDemoGenerator.getPartDemoGenerator().getPartDemoList()) {
            partService.save(part);
        }
    }

	public void importSlsProjects() {
		/**
		 * list of projects imported from default location on hdd
		 */
		List<Project> projectList = ImportData.getImportDataSingleton().importSlsProjects();
		
		/**
		 * converting imported sls data to project class
		 */
		for (Project project : projectList) {	
			project = projectService.convertDataSlsToProject(project);
			//project = projectService.convertModalitySlsToProject(project);
		
			savePrototypeToDbIfNotExist(project.getDetailsSls().getImportedDeviceModelName());
			project.addPrototype(prototypeService.loadByModelName(project.getDetailsSls().getImportedDeviceModelName()));
			//
			//TODO 2022-11-16
			//project = projectService.convertDeviceSlsToPrototypeInProject(project);
			
			projectService.save(project);
		}
	}

	public void savePrototypeToDbIfNotExist(String importedDeviceModelName) {
		if (null == prototypeService.loadByModelName(importedDeviceModelName)) {
			Prototype newPrototype = new Prototype("Smnsh", importedDeviceModelName);
			if (newPrototype.getModelName().contains("Magnet")) {
				newPrototype.setModality(modalityService.loadByCode("MR"));
			}
			if (newPrototype.getModelName().contains("Som")) {
				newPrototype.setModality(modalityService.loadByCode("CT"));
			}
			if (newPrototype.getModelName().contains("Art")) {
				newPrototype.setModality(modalityService.loadByCode("AT"));
			}
			prototypeService.save(newPrototype);
		}
		
	}

	public void importInitDevicesPortfolio() {
		List<String> initDeviceNames = ImportData.getImportDataSingleton().importInitDevicesNames();
		
		for (String deviceName : initDeviceNames) {
			Prototype prototype = new Prototype("SMNSH", deviceName);
			if (prototype.getModelName().contains("Magnet")) {
				prototype.setModality(modalityService.loadByCode("MR"));
			}
			if (prototype.getModelName().contains("Som")) {
				prototype.setModality(modalityService.loadByCode("CT"));
			}
			if (prototype.getModelName().contains("Art")) {
				prototype.setModality(modalityService.loadByCode("AT"));
			}
			prototypeService.save(prototype);
		}
		
	}
	
	public void createAttachmentCategories() {
		for (AttachmentCategory ac: attachmentCategoryDefaultGenerator.initDataAndReturn()) {
			attachmentCategoryService.save(ac);
		}
		
	}

	public void createDemoSubcontractors() {
		for (Subcontractor subcontractor: subcontractorDemoGenerator.initDataAndReturn()) {
			subcontractorService.save(subcontractor);
		}
		
	}

	public void createAndSaveCompanyCategoriesToDb() {
		for (CompanyCategoryEnum comCatEnum : CompanyCategoryEnum.values()) {
			CompanyCategory comCat = new CompanyCategory(comCatEnum);
			System.out.println("App. INFO: saving company category to database: " + companyCategoryService.save(comCat).getCompanyCategoryEnum().toString());
		}
		
	}
	
	/**
	 * Creates and save to database demo companies for smnsh4 package
	 */
	public void createAndSaveDemoCompaniesToDb() {
		for (CompanyCategoryEnum comCatEnum : CompanyCategoryEnum.values()) {
			for (int i = 0; i < 5; i++) {
				
				Company company = new Company();
				
				List<CompanyCategory> ccel = new ArrayList<CompanyCategory>();
				ccel.add(companyCategoryService.loadByCompanyCategoryEnum(comCatEnum));
				if (comCatEnum.equals(CompanyCategoryEnum.INVESTOR)) {
					ccel.add(companyCategoryService.loadByCompanyCategoryEnum(CompanyCategoryEnum.USER));	
				}
				
				company.setCompanyCategoryList(ccel);
				switch (comCatEnum) {
				case INVESTOR:
					company.setName(LoremIpsum.getInstance().getTitle(2) + " Investments GmbH");
					break;
				case SUBCONTRACTOR:
					company.setName(LoremIpsum.getInstance().getTitle(1) + "-BUD Sp. z o.o.");
					break;
				case SUBCONTRACTOR_GENERAL:
					company.setName(LoremIpsum.getInstance().getTitle(1) + "-BUD Sp. z o.o.");
					break;
				case SUBCONTRACTOR_ROOM_ADAPTATION:
					company.setName(LoremIpsum.getInstance().getTitle(1) + "-BUD Sp. z o.o.");
					break;
				case SUPPLIER:
					company.setName(LoremIpsum.getInstance().getTitle(1) + "-Trans. S.A.");
					break;
				case USER:
					company.setName(LoremIpsum.getInstance().getTitle(1) + "-Med. Ltd.");
					break;
				default:
					company.setName(LoremIpsum.getInstance().getTitle(1) + " LLC");
					break;
				}
				
				companyService.saveAndReturn(company);
			}
		}
	}

}