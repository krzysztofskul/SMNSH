package pl.krzysztofskul.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

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

    @GetMapping("/new")
    public String projectNew(
            Model model
    ) {
        model.addAttribute("projectNew", new Project());
        return "projects/new";
    }

    @PostMapping("/new")
    public String projectNew(
            @ModelAttribute("projectNew") Project projectNew
    ) {
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
            Model model
    ) {
        model.addAttribute("project", projectService.loadByIdWithDeviceList(id));
        return "projects/details";
    }

}
