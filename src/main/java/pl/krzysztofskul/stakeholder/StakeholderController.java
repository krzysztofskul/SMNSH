package pl.krzysztofskul.stakeholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.projectCharter.ProjectCharterService;
import pl.krzysztofskul.user.User;

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
		stakeholder.addProjectCharter(projectCharter);
		
		model.addAttribute("stakeholder", stakeholder);
		return "stakeholders/instances/new";
	}
	
	/*TODO 2022-09-21
	/* 
	 * bad request from jsp new stakeholder
	 * check lists in a model from request
	 */
	@PostMapping("/instances/new")
	public String newStakeholderInstance(
			@RequestParam(name = "projectCharterId", required = false) Long projectCharterId,
			@RequestParam(name = "backToPage", required = false) String backToPage,
			@ModelAttribute(name ="stakeholder") Stakeholder stakeholder
	) {
		
		if (stakeholder != null) {
			
			ProjectCharter projectCharter = projectCharterService.loadByIdWithStakeholders(projectCharterId);
			projectCharter.addStakeholder(stakeholderService.saveStakeholder(stakeholder));
			projectCharterService.save(projectCharter);
		}
		
		return "redirect:/"+backToPage;
	}
	
}
