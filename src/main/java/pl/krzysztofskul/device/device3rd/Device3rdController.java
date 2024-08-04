package pl.krzysztofskul.device.device3rd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.project.ProjectService;

@Controller
public class Device3rdController {

	ProjectService projectService;
	Device3rdService device3rdService;
	
	/**
	 * Constructor
	 * @param projectService
	 */
	@Autowired
	public Device3rdController(ProjectService projectService, Device3rdService device3rdService) {
		this.projectService = projectService;
		this.device3rdService = device3rdService;
	}


	@GetMapping("/device3rd/new")
	public String getNewDevice3rd(
				@RequestParam(name = "projectId", required = true) Long projectId,
				Model model
			) {
		Device3rd device3rd = new Device3rd(projectService.loadById(projectId));
		model.addAttribute(device3rd);
		return "devices/device3rd/new";
	}
	
	@PostMapping("/device3rd/new")
	public String postNewDevice3rd(
				@ModelAttribute(name = "device3rd") Device3rd device3rd,
				BindingResult result,
				@RequestParam(required = false) boolean addNextDevice3rd
			) {
		if (result.hasErrors() ) {
			return "error";
		} else {
			device3rdService.saveAndReturn(device3rd);
		}
		if (addNextDevice3rd == true) {
			return "redirect:/device3rd/new?projectId="+device3rd.getProject().getId();
		} else {
			return "redirect:/projects/details/"+device3rd.getProject().getId();
		}
		
	}
	
}
