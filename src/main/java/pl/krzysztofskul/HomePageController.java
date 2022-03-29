package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krzysztofskul.company.type.CompanyTypeService;
import pl.krzysztofskul.initDB.InitDB;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.subcontractor.SubcontractorService;
import pl.krzysztofskul.user.UserService;

@Controller
public class HomePageController {

	/** params. */
	private HomePageService homePageService;
	private UserService userService;
	private CompanyTypeService companyTypeService;
	private SubcontractorService subcontractorService;
	private InvestorService investorService;

	/** constr. */
	@Autowired
	public HomePageController(
			HomePageService homePageService,
			UserService userService,
			CompanyTypeService companyTypeService,
			SubcontractorService subcontractorService,
			InvestorService investorService
	) {
		this.homePageService = homePageService;
		this.userService = userService;
		this.companyTypeService = companyTypeService;
		this.subcontractorService = subcontractorService;
		this.investorService = investorService;
	}

	/** methods */
	
	@GetMapping({"/home", "/"})
	public String home() {
		return "index";
	}

	@GetMapping("/initDB")
	public String initDB() {
		InitDB.getInstanceInitDB();
		if (InitDB.getCounter() == 0) {
			InitDB.increaseCounter();
			companyTypeService.createCompanyTypesAndSaveToDB();
			subcontractorService.createTestSubcontractors();
			investorService.createTestInvestors(15);
			userService.createRealTestUsersAndSaveToDb();
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
			homePageService.initTestMilestonesToDB();;
			homePageService.createProjects();
		}
		return "redirect:/home";
	}

}
