package pl.krzysztofskul.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.krzysztofskul.project.ProjectService;

@Controller
public class ConfigurationController {

	private ConfigurationService configurationService;
	private ProjectService projectService;

	@Autowired
	public ConfigurationController(ConfigurationService configurationService, ProjectService projectService) {
		super();
		this.configurationService = configurationService;
		this.projectService = projectService;
	}



	@GetMapping("/projects/{projectId}/configuration/")
	private String getConfigurationsForProject(
				@PathVariable Long projectId,
				Model model
			) {
		model.addAttribute("configurationList", configurationService.loadAllByProjectIdWithParts(projectId));
		model.addAttribute("project", projectService.loadById(projectId));
		return "projects/configuration/configuration";
	}
}
