package pl.krzysztofskul.importdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

@Controller
@RequestMapping("/import")
public class ImportProjectController {

	ImportProject importProject;
	ProjectService projectService;
	FileSelector fileSelector;
	
	
	@Autowired
	private ImportProjectController(
			ImportProject importProject,
			ProjectService projectService
		) {
		super();
		this.importProject = importProject;
		this.projectService = projectService;
	}

	@GetMapping("/project-by-sls-code/{slsCode}")
	public String importProjectBySlsCode(
			@PathVariable String slsCode
		) {
		Project project = importProject.importProjectBySlsCode(slsCode, null);
		projectService.save(project);
		return "redirect:/";
	}
	
	@GetMapping("/set-default-sls-projects-path")
	public String setDefaultSlsProjectsPath() {
		String path = fileSelector.select("folder");
		ImportData.getImportDataSingleton().setPathProjectsToImport(path);
		System.out.println("App. INFO! New path to sls project folder has been succesfully set.");
		System.out.println(ImportData.getImportDataSingleton().getPathProjectsToImport());
		return "redirect:/";
	}
	
	@GetMapping("/project-by-sls-directory")
	public String importProjectBySlsDirectory() {
		String path = fileSelector.select("folder");
		int index = path.lastIndexOf("\\");
		String slsCode = path.substring(index+1, path.length());
		System.out.println("App. INFO! SLS project coed to import: *"+slsCode+"*");
		Project project = importProject.importProjectBySlsCode(slsCode, null); 
		projectService.save(project);
		return "redirect:/";
	}
	
}
