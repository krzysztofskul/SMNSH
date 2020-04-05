package pl.krzysztofskul.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

@Controller
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/startDemoMode")
    public String startDemoMode(
            HttpSession httpSession
    ) {
        demoService.startDemoMode();

        httpSession.setAttribute("demoSession", Demo.getStep());

        return "redirect:/home";
    }

    @GetMapping("/demoStepNo1")
    public String demoStepNo1(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/initDB";
    }

    @GetMapping("/demoStepNo2")
    public String demoStepNo2(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/login?guest=projectManager";
    }

    @GetMapping("/demoStepNo3")
    public String demoStepNo3(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/all";
    }

    @GetMapping("/demoStepNo4")
    public String demoStepNo4(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/new";
    }

//    @GetMapping("/demoStepNo5")
//    public String demoStepNo5(
//            HttpSession httpSession
//    ) {
//        Demo.increaseStepByOne();
//        httpSession.setAttribute("demoSession", Demo.getStep());
//        return "redirect:/projects/new";
//    }

}
