package pl.krzysztofskul.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.krzysztofskul.attachment.Attachment;
import pl.krzysztofskul.attachment.AttachmentService;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;
import pl.krzysztofskul.subcontractor.Subcontractor;
import pl.krzysztofskul.subcontractor.SubcontractorService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserAction;
import pl.krzysztofskul.user.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;
    private InvestorService investorService;
    private SubcontractorService subcontractorService;
    private DeviceService deviceService;
    private UserService userService;
    private AttachmentService attachmentService;
    private LoggerUserService<Object> loggerUserService;
    private LoggerProjectService<Object> loggerProjectService;

    @Autowired
    public ProjectController(
            ProjectService projectService,
            InvestorService investorService,
            SubcontractorService subcontractorService,
            DeviceService deviceService,
            UserService userService,
            AttachmentService attachmentService,
            LoggerUserService<Object> loggerUserService,
            LoggerProjectService<Object> loggerProjectService
    ) {
        this.projectService = projectService;
        this.investorService = investorService;
        this.subcontractorService = subcontractorService;
        this.deviceService = deviceService;
        this.userService = userService;
        this.attachmentService = attachmentService;
        this.loggerUserService = loggerUserService;
        this.loggerProjectService = loggerProjectService;
    }

    @ModelAttribute("allDeviceList")
    public List<Device> getAllDeviceList() {
        return deviceService.loadAll();
    }

    @ModelAttribute("allProjectManagerList")
    public List<User> getAllUserList() {
        return userService.loadAllProjectManagers();
    }

    @ModelAttribute("allStatusesProject")
    public List<StatusProject> getAllStatusesProject() {
        return Arrays.asList(StatusProject.values());
    }

    @ModelAttribute("allInvestorList")
    public List<Investor> getAllInvestorList() {
        return investorService.loadAll();
    }

    @ModelAttribute("allSubcontractorList")
    public List<Subcontractor> getAllSubcontractorList() {
        return subcontractorService.loadAll();
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
            @RequestParam(name = "fileUpload", required = false) MultipartFile fileUpload,
            @ModelAttribute("projectNew") @Valid Project projectNew, BindingResult result,
            @RequestParam(name = "backToPage", required = false) String backToPage,
            HttpSession httpSession
    ) throws IOException {

//        attachmentService.save(fileUpload);

        if (result.hasErrors()) {
            return "/projects/new";
        }

        if (projectNew.getId() == null) {
            projectService.save(projectNew);
            loggerUserService.log((User) httpSession.getAttribute("userLoggedIn"), LocalDateTime.now(), UserAction.PROJECT_CREATE, projectNew);
            loggerProjectService.log(projectNew, ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toLocalDateTime(), "PROJECT CREATED", httpSession.getAttribute("userLoggedIn"));
        } else {
            projectService.save(projectNew);
            loggerUserService.log((User) httpSession.getAttribute("userLoggedIn"), LocalDateTime.now(), UserAction.PROJECT_CREATE, projectNew);
            loggerProjectService.log(projectNew, ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toLocalDateTime(), "PROJECT UPDATED", httpSession.getAttribute("userLoggedIn"));
        }
        if (fileUpload != null && !fileUpload.isEmpty()) {
            attachmentService.saveToProject(fileUpload, projectNew);
            loggerProjectService.log(projectNew, ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toLocalDateTime(), "ATTACHMENT ADDED", httpSession.getAttribute("userLoggedIn"));
        }
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
        return "redirect:/projects/all";
    }

    @GetMapping("/all")
    public String projectsAll(
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "userId", required = false) Long userId,
            Model model
    ) {
        if (status == null) {
            List<Project> projectsAll = projectService.loadAllWithDeviceList();
            if (userId != null) {
                projectsAll.removeIf(project -> !project.getProjectManager().getId().equals(userId));
            }
//            projectsAll.sort((Project o1, Project o2) -> o2.getId().compareTo(o1.getId()));
            if (projectsAll != null) {
                projectsAll.sort(new Comparator<Project>() {
                    @Override
                    public int compare(Project o1, Project o2) {
                        return o2.getId().compareTo(o1.getId());
                    }
                });
            }
            model.addAttribute("projectsAll", projectsAll);
            return "projects/all";
        }
        if ("acquisition".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_0));
            model.addAttribute("projectStatus", "AKWIZYCJA");
            return "projects/allByStatus";
        }
        else if ("preliminaryPlanning".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_1));
            model.addAttribute("projectStatus", "PROJEKT KONCEPCYJNY");
            return "projects/allByStatus";
        }
        else if ("finalPlanning".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_2));
            model.addAttribute("projectStatus", "PROJEKT WYTYCZNYCH");
            return "projects/allByStatus";
        }
        else if ("roomPreparation".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_3));
            model.addAttribute("projectStatus", "ADAPTACJA POMIESZCZĘŃ");
            return "projects/allByStatus";
        }
        else if ("delivery".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_4));
            model.addAttribute("projectStatus", "DOSTAWA URZĄDZEŃ");
            return "projects/allByStatus";
        }
        else if ("installation".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_5));
            model.addAttribute("projectStatus", "INSTALACJA URZĄDZEŃ");
            return "projects/allByStatus";
        }
        else if ("startUp".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_6));
            model.addAttribute("projectStatus", "URUCHOMIENIE");
            return "projects/allByStatus";
        }
        else if ("trainings".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_7));
            model.addAttribute("projectStatus", "SZKOLENIA");
            return "projects/allByStatus";
        }
        else if ("finished".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_8));
            model.addAttribute("projectStatus", "ZAKOŃCZONY");
            return "projects/allByStatus";
        }
        else if ("cancelled".equals(status)) {
            model.addAttribute("projectsAllByStatus", projectService.loadAllByStatusWithDevices(StatusProject.STATUS_PROJECT_8));
            model.addAttribute("projectStatus", "ANULOWANY");
            return "projects/allByStatus";
        }
        else {
            return "projects/all";
        }

    }

    @GetMapping("/details/{id}")
    public String projectDetails(
            @PathVariable("id") Long id,
            @RequestParam(name = "edit", required = false) String edit,
            @RequestParam(name = "backToPage", required = false) String backToPage,
            Model model
    ) {
        if (edit == null && model.containsAttribute("edit")) {
            model.addAttribute("edit", false);
        }
        if (edit  != null && edit.equals("true")) {
            model.addAttribute("edit", true);
        }
        if (backToPage != null) {
            model.addAttribute("backToPage", backToPage);
        }
        model.addAttribute("project", projectService.loadByIdWithDeviceListAndConceptList(id));
        return "projects/details";
    }

    @GetMapping("/details/{id}/comments")
    public String projectDetailsWithComments(
            @PathVariable(name = "id") Long id,
            Model model
    ) {
        model.addAttribute("projectWithComments", projectService.loadByIdWithComments(id));
        return "projects/comments/allByProjectId";
    }

    @PostMapping("/details/{id}")
    public String projectDetails(
            @PathVariable("id") Long id,
            @ModelAttribute("project") @Valid Project project, BindingResult result,
            @ModelAttribute("backToPage") String backToPage,
            Model model,
            HttpSession httpSession
    ) {
        if (result.hasErrors()) {
            return "/projects/details/"+id.toString()+"?edit=true";
        }

        if (model.containsAttribute("edit")) {
            model.addAttribute("edit", false);
        }
        projectService.save(project);
        loggerProjectService.log(project, ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toLocalDateTime(), "PROJECT UPDATED", httpSession.getAttribute("userLoggedIn"));
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
        return "redirect:/projects/details/"+id;
    }

    @GetMapping("/{projectId}/attachment-download/{attachmentId}")
    public String attachmentDownload(
            @PathVariable("projectId") Long projectId,
            @PathVariable("attachmentId") Long attachmentId,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        Attachment attachment = attachmentService.loadById(attachmentId);
        httpServletResponse.setContentType(attachment.getFileType());
        httpServletResponse.setContentLength(attachment.getData().length);
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\""+attachment.getFileName()+"\"");
        FileCopyUtils.copy(attachment.getData(), httpServletResponse.getOutputStream());
        return "redirect:/projects/details/"+projectId;

    }

    @GetMapping("/delete/{id}")
    public String deleteProjectById(
            @PathVariable(name = "id") Long projectId
    ) {
        projectService.deleteById(projectId);
        return "redirect:/projects/all";
    }

}
