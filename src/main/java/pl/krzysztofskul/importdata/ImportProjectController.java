package pl.krzysztofskul.importdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

@Controller
public class ImportProjectController {

	ImportProject importProject;
	ProjectService projectService;
	
	
	@Autowired
	private ImportProjectController(
			ImportProject importProject,
			ProjectService projectService
		) {
		super();
		this.importProject = importProject;
		this.projectService = projectService;
	}

	@GetMapping("/import-project-by-sls-code/{slsCode}")
	public String importProjectBySlsCode(
			@PathVariable String slsCode
		) {
		Project project = importProject.importProjectBySlsCode(slsCode, null);
		projectService.save(project);
		return "redirect:/";
	}
	
}
