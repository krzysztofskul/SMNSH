package pl.krzysztofskul.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;
    private DeviceService deviceService;
    private UserService userService;

    @Autowired
    public ProjectController(
            ProjectService projectService,
            DeviceService deviceService,
            UserService userService
    ) {
        this.projectService = projectService;
        this.deviceService = deviceService;
        this.userService = userService;
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
            @ModelAttribute("projectNew") @Valid Project projectNew, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/projects/new";
        }
        projectService.save(projectNew);
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
        model.addAttribute("project", projectService.loadByIdWithDeviceList(id));
        return "projects/details";
    }

    @PostMapping("/details/{id}")
    public String projectDetails(
            @PathVariable("id") Long id,
            @ModelAttribute("project") @Valid Project project, BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "projects/details/"+id+"?edit=true";
        }

        if (model.containsAttribute("edit")) {
            model.addAttribute("edit", false);
        }
        projectService.save(project);
        return "redirect:/projects/details/"+id;
    }

}
