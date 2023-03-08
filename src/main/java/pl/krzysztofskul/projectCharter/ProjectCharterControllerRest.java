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

    @PostMapping("/{id}")
    public ProjectCharter putProjectCharter(
            @PathVariable Long id,
            @RequestParam String reasons,
            @RequestParam String risks,
            @RequestParam String goals

    ) {
        ProjectCharter projectCharter = projectCharterService.loadById(id);
    	
        if (!reasons.equals(projectCharter.getReasons())) {
        	projectCharter.setReasons(reasons.trim());
        }
        if (!reasons.equals(projectCharter.getRisks())) {
        	projectCharter.setRisks(risks.trim());
        }
        if (!reasons.equals(projectCharter.getGoals())) {
        	projectCharter.setGoals(goals.trim());
        }
        
        
    	return projectCharterService.save(projectCharter);
    	
    }

}
