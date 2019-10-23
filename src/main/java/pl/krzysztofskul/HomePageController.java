package pl.krzysztofskul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

	/** params. */
	
	/** constr. */
	
	/** methods */
	
	@GetMapping({"/home", "/"})
	public String home() {
		return "index";
	}
	
}
