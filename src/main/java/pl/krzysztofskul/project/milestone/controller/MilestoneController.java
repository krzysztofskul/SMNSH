package pl.krzysztofskul.project.milestone.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.service.MilestoneService;
import pl.krzysztofskul.projectCharter.ProjectCharterService;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {

	private MilestoneService milestoneService;
	private ProjectCharterService projectCharterService;

	@Autowired
	public MilestoneController(
			MilestoneService milestoneService,
			ProjectCharterService projectCharterService
	) {
		super();
		this.milestoneService = milestoneService;
		this.projectCharterService = projectCharterService;
	}
	
	@GetMapping("/instances/new")
	public String newinstance(
			@RequestParam Long projectCharterId,
			@RequestParam String backToPage,
			HttpServletResponse httpServletResponse,
			HttpServletRequest httpServletRequest
	) {
			httpServletRequest.setAttribute("backToPage", backToPage);
			httpServletRequest.setAttribute("projectCharterId", projectCharterId);

		return "/milestones/instances/new";
		
	}
	
	@PostMapping("/instances/new")
	public String newinstanceSave(
			@RequestParam String namePL,
			@RequestParam String nameEN,
			@RequestParam String description,
			@RequestParam String dateStartPlanned,
			@RequestParam String dateFinishPlanned,
			@RequestParam String dateStarted,
			@RequestParam String dateFinished,
			@RequestParam Long projectCharterId,
			@RequestParam String backToPage
	) {
		MilestoneInstance milestoneInstance = new MilestoneInstance();
		milestoneInstance.setNamePL(namePL);
		milestoneInstance.setNameEN(nameEN);
		milestoneInstance.setDescription(description);
		milestoneInstance.getMilestoneTimeline().setDateStartPlanned(LocalDate.parse(dateStartPlanned));
		milestoneInstance.getMilestoneTimeline().setDateFinishPlanned(LocalDate.parse(dateFinishPlanned));
		milestoneInstance.getMilestoneTimeline().setDateStarted(LocalDate.parse(dateStarted));
		milestoneInstance.getMilestoneTimeline().setDateFinished(LocalDate.parse(dateFinished));
		milestoneInstance.setId(milestoneService.saveMilestoneInstance(milestoneInstance).getId());
		
		projectCharterService.addMilestoneInstance(projectCharterId, milestoneInstance.getId());

		return "redirect:/"+backToPage;
	}
	
	
}
