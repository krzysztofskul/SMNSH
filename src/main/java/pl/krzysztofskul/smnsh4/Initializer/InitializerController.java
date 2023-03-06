package pl.krzysztofskul.smnsh4.Initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/smnsh4/initialize-data")
public class InitializerController {

	private InitilizerService initilizerService;
	
	/**
	 * Constructor
	 */
	@Autowired
	public InitializerController(InitilizerService initilizerService) {
		this.initilizerService = initilizerService;
	}

	@GetMapping(name = "/essentials")
	public void initializeEssentialData() {
		initilizerService.initializeEssentialData();
	}
	
}
