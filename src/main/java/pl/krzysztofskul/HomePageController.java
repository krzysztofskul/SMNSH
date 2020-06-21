package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krzysztofskul.company.type.CompanyTypeService;
import pl.krzysztofskul.initDB.InitDB;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.subcontractor.SubcontractorService;

@Controller
public class HomePageController {

	/** params. */
	private HomePageService homePageService;
	private CompanyTypeService companyTypeService;
	private SubcontractorService subcontractorService;
	private InvestorService investorService;

	/** constr. */
	@Autowired
	public HomePageController(
			HomePageService homePageService,
			CompanyTypeService companyTypeService,
			SubcontractorService subcontractorService,
			InvestorService investorService
	) {
		this.homePageService = homePageService;
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
			homePageService.createRealTestUsers();
			homePageService.createUsers();
			homePageService.createDeviceCategories();
			homePageService.createDevices();
			homePageService.createRealTestDevices();
			homePageService.createConcepts();
			homePageService.createGuidelines();
//			homePageService.createInvestors();
			homePageService.createRealTestInvestors();
			homePageService.createRecipients();
			homePageService.createRealTestRecipients();
			homePageService.createProjects();
		}
		return "redirect:/home";
	}

}
