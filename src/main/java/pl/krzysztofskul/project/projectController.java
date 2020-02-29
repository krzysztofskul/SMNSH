package pl.krzysztofskul.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class projectController {

    private ProjectService projectService;

    @Autowired
    public projectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/new")
    public String projectNew(
            Model model
    ) {
        model.addAttribute("projectNew", new Project());
        return "projects/new";
    }

    @PostMapping("/new")
    public String projectNew(
            @ModelAttribute("projectNew") Project projectNew
    ) {
        projectService.save(projectNew);
        return "projects/all";
    }

    @GetMapping("/all")
    public String projectsAll(
            Model model
    ) {
        model.addAttribute("projectsAll", projectService.loadAll());
        return "projects/all";
    }

}
