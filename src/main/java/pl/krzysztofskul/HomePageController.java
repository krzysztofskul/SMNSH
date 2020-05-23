package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krzysztofskul.initDB.InitDB;

@Controller
public class HomePageController {

	/** params. */
	private HomePageService homePageService;

	/** constr. */
	@Autowired
	public HomePageController(HomePageService homePageService) {
		this.homePageService = homePageService;
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
			homePageService.createRealTestUsers();
			homePageService.createUsers();
			homePageService.createDeviceCategories();
			homePageService.createDevices();
			homePageService.createRealTestDevices();
			homePageService.createConcepts();
			homePageService.createGuidelines();
			homePageService.createInvestors();
			homePageService.createRealTestInvestors();
			homePageService.createRecipients();
			homePageService.createRealTestRecipients();
			homePageService.createProjects();
		}
		return "redirect:/home";
	}

}
