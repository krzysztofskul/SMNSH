package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krzysztofskul.company.type.CompanyTypeService;
import pl.krzysztofskul.device.modality.ModalityGenerator;
import pl.krzysztofskul.initDB.InitDB;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.stakeholder.StakeholderService;
import pl.krzysztofskul.subcontractor.SubcontractorService;
import pl.krzysztofskul.user.UserService;

@Controller
public class HomePageController {

	/** params. */
	private int initEssentialDBCounter = 0;
	
	private HomePageService homePageService;
	private UserService userService;
	private CompanyTypeService companyTypeService;
	private SubcontractorService subcontractorService;
	private InvestorService investorService;
	private StakeholderService stakeholderService; 
	private ModalityGenerator modalityGenerator;

	/** constr. */
	@Autowired
	public HomePageController(
			HomePageService homePageService,
			UserService userService,
			CompanyTypeService companyTypeService,
			SubcontractorService subcontractorService,
			InvestorService investorService,
			StakeholderService stakeholderService,
			ModalityGenerator modalityGenerator
	) {
		this.homePageService = homePageService;
		this.userService = userService;
		this.companyTypeService = companyTypeService;
		this.subcontractorService = subcontractorService;
		this.investorService = investorService;
		this.stakeholderService = stakeholderService;
		this.modalityGenerator = modalityGenerator;
	}

	/** methods */
	
	@GetMapping({"/home", "/"})
	public String home() {
		return "index";
	}

	@GetMapping("/initEssentialDB")
	public String initEssentialDB() {
		if (initEssentialDBCounter == 0) {
			
			userService.createRealTestUsersAndSaveToDb();
			homePageService.createAndSaveCompanyCategoriesToDb();
			homePageService.createAttachmentCategories();
			modalityGenerator.initModalityDb();
		
			initEssentialDBCounter++;
		}
		return "redirect:/home";
	}
	
	@GetMapping("/initDemoDB")
	public String initDB() {
		if (this.initEssentialDBCounter > 0) {
			InitDB.getInstanceInitDB();
			if (InitDB.getCounter() == 0) {
				InitDB.increaseCounter();

				homePageService.createAndSaveDemoCompaniesToDb();
				homePageService.initializeMilestoneTemplatesToDb();
				
				try {
					homePageService.importInitDevicesPortfolio();
				} catch (Exception e) {
					System.err.println("ERROR! Can't init devices portfolio!");
				}
				homePageService.createParts();
			
			}
		}
		return "redirect:/home";
	}
	
	@GetMapping("/importSlsProjects")
	public String importSlsProjects() {
		homePageService.importSlsProjects();
		return "redirect:/home";
	}
	
	@GetMapping("/importInitDevicesPortfolio")
	public String importInitDevicesPortfolio() {
		homePageService.importInitDevicesPortfolio();
		return "redirect:/home";
	}
	
}
