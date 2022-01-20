package pl.krzysztofskul.projectCharter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/project-charter")
public class ProjectCharterControllerRest {

    private ProjectCharterService projectCharterService;

    @Autowired
    public ProjectCharterControllerRest(ProjectCharterService projectCharterService) {
        this.projectCharterService = projectCharterService;
    }

    @GetMapping("/{id}")
    public ProjectCharter getProjectCharter(
            @PathVariable Long id
    ) {
        return projectCharterService.loadById(id);
    }

    @PutMapping("/{id}")
    public ProjectCharter putProjectCharter(
            @PathVariable Long id,
            @RequestBody ProjectCharter projectCharterPut

    ) {
        ProjectCharter projectCharter = projectCharterService.loadById(id);

        projectCharterPut.setProject(projectCharter.getProject());


        return projectCharterService.save(projectCharterPut);
    }

}
