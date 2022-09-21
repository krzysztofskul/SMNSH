package pl.krzysztofskul.stakeholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.projectCharter.ProjectCharterService;

@Controller
@RequestMapping("/stakeholders")
public class StakeholderController {

	private StakeholderService stakeholderService;
	private ProjectCharterService projectCharterService;

	@Autowired
	public StakeholderController(StakeholderService stakeholderService, ProjectCharterService projectCharterService) {
		super();
		this.stakeholderService = stakeholderService;
		this.projectCharterService = projectCharterService;
	}
	
	@GetMapping("/instances/new")
	public String newStakeholderInstance(
			@RequestParam(name = "projectCharterId") Long projectCharterId,
			@RequestParam(name = "backToPage") String backToPage,
			Model model
	) {
		ProjectCharter projectCharter = projectCharterService.loadByIdWithStakeholders(projectCharterId);
		
		Stakeholder stakeholder = new Stakeholder();
		//TODO: prepare new stakeholder for project charter to add
		
		stakeholder.addProjectCharter(projectCharter); // initial connection project charter to stakeholder doesnt work....
		
		
		model.addAttribute("stakeholder", stakeholder);
		return "stakeholders/instances/new";
	}
	
	
}
