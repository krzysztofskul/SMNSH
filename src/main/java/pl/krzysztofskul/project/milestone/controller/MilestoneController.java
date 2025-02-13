package pl.krzysztofskul.project.milestone.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.repo.MilestoneInstanceRepo;
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
			@RequestParam (required = false) String nameEN,
			@RequestParam String description,
			@RequestParam (required = false) String dateStartPlanned,
			@RequestParam String dateFinishPlanned,
			@RequestParam (required = false) String dateStarted,
			@RequestParam (required = false) String dateFinished,
			@RequestParam Long projectCharterId,
			@RequestParam String backToPage
	) {
		MilestoneInstance milestoneInstance = new MilestoneInstance();
		milestoneInstance.setNamePL(namePL);
		milestoneInstance.setNameEN(nameEN);
		milestoneInstance.setDescription(description);
		
		if (dateStartPlanned == null) {
			//dateStartPlanned = LocalDate.now().toString();
		} else {
			try {
				milestoneInstance.getMilestoneTimeline().setDateStartPlanned(LocalDate.parse(dateStartPlanned));
			} catch (java.time.format.DateTimeParseException e) {
				dateStartPlanned = null;
			}
		}
		if (dateFinishPlanned == null) {
			//dateFinishPlanned = LocalDate.now().toString();
		} else {
			try {
				milestoneInstance.getMilestoneTimeline().setDateFinishPlanned(LocalDateTime.parse(dateFinishPlanned));
			} catch (java.time.format.DateTimeParseException e) {
				dateFinishPlanned = null;
			}
				
		}
		if (dateStarted == null) {
			//dateStarted = LocalDate.now().toString();
		} else {
			try {
				milestoneInstance.getMilestoneTimeline().setDateStarted(LocalDate.parse(dateStarted));	
			} catch (java.time.format.DateTimeParseException e) {
				dateStarted = null;
			}
			
		}
		if (dateFinished == null) {
			//dateFinished = LocalDate.now().toString();
		} else {
			try {
				milestoneInstance.getMilestoneTimeline().setDateFinished(LocalDate.parse(dateFinished));
			} catch (java.time.format.DateTimeParseException e) {
				dateFinished = null;
			}
				
		}

		milestoneInstance.setId(milestoneService.saveMilestoneInstance(milestoneInstance).getId());
		
		projectCharterService.addMilestoneInstance(projectCharterId, milestoneInstance.getId());

		return "redirect:/"+backToPage;
	}
	
	@GetMapping("/instances/edit/{projectCharterId}/{milestoneInstanceId}")
	public String editinstance(
			@PathVariable Long milestoneInstanceId,
			@RequestParam(name = "backToPage", required = false) String backToPage,
			Model model,
			HttpServletRequest httpServletRequest
	) {
		
		model.addAttribute("milestoneInstance", milestoneService.loadMielestoneInstanceById(milestoneInstanceId));
		httpServletRequest.setAttribute("backToPage", backToPage);
		
		return "/milestones/instances/edit";
	}
	
	@GetMapping("/instances/setStatus/{projectCharterId}/{milestoneInstanceId}")
	public String setStatus(
			@PathVariable Long milestoneInstanceId,
			@RequestParam(name = "backToPage", required = false) String backToPage,
			@RequestParam(name = "newStatus", required = true) String newStatus
			) {
		MilestoneInstance milestoneInstance = milestoneService.loadMielestoneInstanceById(milestoneInstanceId);
		
		switch (newStatus) {
		case "waitingTrue": {
			milestoneInstance.setStatusWaiting(true);
			milestoneInstance.setStatusInProgress(false);
			milestoneInstance.setStatusFinnished(false);
			milestoneInstance.setStatusCanceled(false);
			break;
		}
		case "waitingFalse": {
			milestoneInstance.setStatusWaiting(false);
			break;
		}
		case "inProgressTrue": {
			milestoneInstance.setStatusInProgress(true);
			milestoneInstance.setStatusWaiting(false);
			milestoneInstance.setStatusFinnished(false);
			milestoneInstance.setStatusCanceled(false);
			break;
		}
		case "inProgressFalse": {
			milestoneInstance.setStatusInProgress(false);
			break;
		}
		case "finnishedTrue": {
			milestoneInstance.setStatusFinnished(true);
			milestoneInstance.setStatusWaiting(false);
			milestoneInstance.setStatusInProgress(false);
			milestoneInstance.setStatusCanceled(false);
			break;
		}
		case "finnishedFalse": {
			milestoneInstance.setStatusFinnished(false);
			break;
		}
		case "canceledTrue": {
			milestoneInstance.setStatusCanceled(true);
			milestoneInstance.setStatusWaiting(false);
			milestoneInstance.setStatusInProgress(false);
			milestoneInstance.setStatusFinnished(true);
			break;
		}
		case "canceledFalse": {
			milestoneInstance.setStatusCanceled(false);
			break;
		}

		//TODO error page and redirect to error page when @RequestParam newStatus is null or incorrect
		default:
			return "redirect:/"+backToPage;
		}
		
		milestoneService.saveMilestoneInstance(milestoneInstance);
		
		return "redirect:/"+backToPage;
	}
	
	@PostMapping("/instances/saveEdited")
	public String putMilestoneInstance(
			@RequestParam(name = "backToPage", required = false) String backToPage,
			@ModelAttribute MilestoneInstance milestoneInstance
			) {
		
		milestoneService.saveMilestoneInstance(milestoneInstance);
		
		return "redirect:/"+backToPage;
	}
	
	@GetMapping("/instances/delete/{projectCharterId}/{milestoneInstanceId}")
	private String deleteMilestoneInstance(
			@PathVariable Long projectCharterId,
			@PathVariable Long milestoneInstanceId,
			@RequestParam String backToPage
	) {
		projectCharterService.removeMilestoneInstance(projectCharterService.loadByIdWithMilestoneInstanceList(projectCharterId).getProject().getId(), milestoneInstanceId);
		return "redirect:/"+backToPage;
	}
}
