package pl.krzysztofskul.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.project.StatusProject;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class DemoController {

    private DemoService demoService;
    private ProjectService projectService;
    private UserService userService;
    private DeviceService deviceService;

    @Autowired
    public DemoController(DemoService demoService, ProjectService projectService, UserService userService, DeviceService deviceService) {
        this.demoService = demoService;
        this.projectService = projectService;
        this.userService = userService;
        this.deviceService = deviceService;
    }

    @ModelAttribute("allStatusesProject")
    public List<StatusProject> getAllStatusesProject() {
        return Arrays.asList(StatusProject.values());
    }

    @ModelAttribute("allProjectManagerList")
    public List<User> getAllUserList() {
        return userService.loadAllProjectManagers();
    }

    @ModelAttribute("allDeviceList")
    public List<Device> getAllDeviceList() {
        return deviceService.loadAll();
    }

    @GetMapping("/startDemoMode")
    public String startDemoMode(
            HttpSession httpSession
    ) {
        demoService.startDemoMode();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/home";
    }

    @GetMapping("/demoStepNumber1")
    public String demoStepNumber1(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/initDB";
    }

    @GetMapping("/demoStepNumber2")
    public String demoStepNumber2(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/login?guest=projectManager";
    }

    @GetMapping("/demoStepNumber3")
    public String demoStepNumber3(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/all";
    }

    @GetMapping("/demoStepNumber4")
    public String demoStepNumber4(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/new";
    }

    @PostMapping("/demoStepNumber5")
    public String demoStepNumber5(
            HttpSession httpSession,
            @ModelAttribute("projectNew") @Valid Project projectNew, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/projects/new";
        }
        projectService.save(projectNew);
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/all";
    }
    
    @GetMapping("/demoStepNumber6")
    public String demoStepNumber6(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/logout";
    }

    @GetMapping("/demoStepNumber7")
    public String demoStepNumber7(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/login?guest=designer";
    }

    @GetMapping("/demoStepNumber8")
    public String demoStepNumber8(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/all";
    }

}
