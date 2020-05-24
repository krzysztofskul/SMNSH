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
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserAction;
import pl.krzysztofskul.user.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;
    private DeviceService deviceService;
    private UserService userService;
    private AttachmentService attachmentService;
    private LoggerUserService<Object> loggerUserService;

    @Autowired
    public ProjectController(
            ProjectService projectService,
            DeviceService deviceService,
            UserService userService,
            AttachmentService attachmentService,
            LoggerUserService<Object> loggerUserService
    ) {
        this.projectService = projectService;
        this.deviceService = deviceService;
        this.userService = userService;
        this.attachmentService = attachmentService;
        this.loggerUserService = loggerUserService;
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
            HttpSession httpSession
    ) throws IOException {

//        attachmentService.save(fileUpload);

        if (result.hasErrors()) {
            return "/projects/new";
        }
        projectService.save(projectNew);
        loggerUserService.log((User) httpSession.getAttribute("userLoggedIn"), LocalDateTime.now(), UserAction.PROJECT_CREATE, projectNew);
        if (fileUpload != null && !fileUpload.isEmpty()) {
            attachmentService.saveToProject(fileUpload, projectNew);
        }
        return "redirect:/projects/all";
    }

    @GetMapping("/all")
    public String projectsAll(
            Model model
    ) {
        model.addAttribute("projectsAll", projectService.loadAllWithDeviceList());
        return "projects/all";
    }

    @GetMapping("/details/{id}")
    public String projectDetails(
            @PathVariable("id") Long id,
            @RequestParam(name = "edit", required = false) String edit,
            Model model
    ) {
        if (edit == null && model.containsAttribute("edit")) {
            model.addAttribute("edit", false);
        }
        if (edit  != null && edit.equals("true")) {
            model.addAttribute("edit", true);
        }
        model.addAttribute("project", projectService.loadByIdWithDeviceListAndConceptList(id));
        return "projects/details";
    }

    @PostMapping("/details/{id}")
    public String projectDetails(
            @PathVariable("id") Long id,
            @ModelAttribute("project") @Valid Project project, BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "/projects/details/"+id.toString()+"?edit=true";
        }

        if (model.containsAttribute("edit")) {
            model.addAttribute("edit", false);
        }
        projectService.save(project);
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

}
