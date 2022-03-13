package pl.krzysztofskul.projectCharter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project-charter")
public class ProjectCharterController {

    private ProjectCharterService projectCharterService;

    @Autowired
    public ProjectCharterController(ProjectCharterService projectCharterService) {
        this.projectCharterService = projectCharterService;
    }

    @GetMapping("/{id}")
    private String getProjectCharterById(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute("projectCharter", projectCharterService.loadByIdWithMilestoneInstanceList(id));
        return "/projectCharter/project-charter";
    }

}
