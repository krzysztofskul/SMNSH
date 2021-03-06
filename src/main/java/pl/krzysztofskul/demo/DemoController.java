package pl.krzysztofskul.demo;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.order.guideline.GuidelineService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.project.StatusProject;
import pl.krzysztofskul.questionnaire.QuestionForm;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForCT;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForMRI;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForXRAY;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserAction;
import pl.krzysztofskul.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class DemoController {

    private DemoService demoService;
    private ProjectService projectService;
    private UserService userService;
    private DeviceService deviceService;
    private ConceptService conceptService;
    private GuidelineService guidelineService;
    private LoggerUserService<Object> loggerUserService;

    @Autowired
    public DemoController(DemoService demoService, ProjectService projectService, UserService userService, DeviceService deviceService, ConceptService conceptService, GuidelineService guidelineService, LoggerUserService<Object> loggerUserService) {
        this.demoService = demoService;
        this.projectService = projectService;
        this.userService = userService;
        this.deviceService = deviceService;
        this.conceptService = conceptService;
        this.guidelineService = guidelineService;
        this.loggerUserService = loggerUserService;
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

    @ModelAttribute("devicesAll")
    public List<Device> getDevicesAll() {
        return deviceService.loadAll();
    }

    @GetMapping("/startDemoMode")
    public String startDemoMode(
            HttpSession httpSession,
            HttpServletRequest httpServletRequest
    ) {
        demoService.startDemoMode();
        httpSession.setAttribute("demoSession", Demo.getStep());
//        httpSession.setAttribute("demoModeStatus", "ON");
        loggerUserService.log((User) httpSession.getAttribute("userLoggedIn"), LocalDateTime.now(), UserAction.DEMO_MODE_START, httpServletRequest.getHeader("User-Agent"));
        return "redirect:/home";
    }

    @GetMapping("/demoModeOff")
    public String turnOffDemoMode(
            HttpSession httpSession
    ) {
//        httpSession.setAttribute("demoModeStatus", "OFF");
        Demo.resetSteps();
        httpSession.removeAttribute("demoSession");
        //projectService.deleteByProjectName("DEMO PROJECT NAME");
        Project project = projectService.loadByProjectName("DEMO PROJECT NAME");
        if (project != null) {
            project.setProjectName(project.getProjectName()+" (ARCH.)");
            projectService.save(project);
        }
        if (httpSession.getAttribute("userLoggedIn") != null) {
            return "redirect:/logout";
        }
        return "redirect:/home";
    }

    @GetMapping("/demoModeReset")
    public String demoModeReset(
            HttpSession httpSession
    ) {
        Demo.resetSteps();
        httpSession.setAttribute("demoSession", Demo.getStep());
        projectService.deleteByProjectName("DEMO PROJECT NAME");
        if (httpSession.getAttribute("userLoggedIn") != null) {
            return "redirect:/logout";
        }
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
    
//    @GetMapping("/demoStepNumber6")
//    public String demoStepNumber6(
//            HttpSession httpSession
//    ) {
//        Demo.increaseStepByOne();
//        httpSession.setAttribute("demoSession", Demo.getStep());
//        return "redirect:/logout";
//    }
    @GetMapping("/demoStepNumber6/{projectId}")
    public String demoStepNumber6(
            HttpSession httpSession,
            @PathVariable("projectId") Long projectId
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/details/"+projectId;
    }

//    @GetMapping("/demoStepNumber7")
//    public String demoStepNumber7(
//            HttpSession httpSession
//    ) {
//        Demo.increaseStepByOne();
//        httpSession.setAttribute("demoSession", Demo.getStep());
//        return "redirect:/login?guest=designer";
//    }

    @GetMapping("/demoStepNumber7")
    public String demoStepNumber7(
            @RequestParam("projectId") Long projectId,
            @RequestParam("userId") Long userId,
            HttpSession httpSession
    ) {
        //return "redirect:/login?guest=designer";
        return "redirect:/demoStepNumber8?projectId="+projectId+"&userId="+userId;

    }

    @GetMapping("/demoStepNumber8")
    public String conceptsNew(
            @RequestParam(name = "userId", required = false) Long userId,
            @RequestParam(name = "projectId", required = false) Long projectId,
//            @RequestParam(name = "backToPage", required = false) String backToPage,
            Model model,
            HttpSession httpSession
    ) {
        Concept conceptNew = new Concept();
        if (userId != null) {
            conceptNew.setAuthor(userService.loadById(userId));
        }
        if (projectId != null) {
            conceptNew.setProject(projectService.loadByIdWithDeviceList(projectId));
        }
        model.addAttribute("conceptNew", conceptNew);
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        model.addAttribute("backToPage", "/projects/details/"+projectId);
        return "orders/concepts/new";
    }

    @PostMapping("/demoStepNumber8")
    public String demoStepNumber8(
        @ModelAttribute("conceptNew") @Valid Concept conceptNew,
        @RequestParam(name = "backToPage", required = false) String backToPage,
        BindingResult result,
        Model model,
        HttpSession httpSession
    ) {
        if (result.hasErrors()) {
            return "orders/concepts/new";
        }

        if (conceptNew.getQuestionForm() == null) {
            /****************************
             * ADDITION QUESTION SET REDIRECT (DEPENDS ON DEVICE CATEGORY)
             */
            Device device = deviceService.loadById(conceptNew.getDevice().getId());
            Hibernate.initialize(device.getDeviceCategory());
            switch (device.getDeviceCategory().getCode()) {
                case "MRI": {
                    QuestionForm questionForm = new QuestionForm();
                    if (backToPage != null) {
                        questionForm.setBackToPage(backToPage);
                    }
                    QuestionSetForMRI questionSetForMRI = new QuestionSetForMRI();

                    questionForm.setQuestionSetForMRI(questionSetForMRI);
                    questionSetForMRI.setQuestionForm(questionForm);
                    questionForm.setConcept(conceptNew);
                    conceptNew.setQuestionForm(questionForm);

                    conceptService.save(conceptNew);
                    Demo.increaseStepByOne();
                    httpSession.setAttribute("demoSession", Demo.getStep());
                    model.addAttribute("questionSetForMRI", questionSetForMRI);
                    return "questionSets/questionSetMRI";
                }
                case "CT": {
                    QuestionForm questionForm = new QuestionForm();
                    if (backToPage != null) {
                        questionForm.setBackToPage(backToPage);
                    }
                    QuestionSetForCT questionSetForCT = new QuestionSetForCT();

                    questionForm.setQuestionSetForCT(questionSetForCT);
                    questionSetForCT.setQuestionForm(questionForm);
                    questionForm.setConcept(conceptNew);
                    conceptNew.setQuestionForm(questionForm);

                    conceptService.save(conceptNew);
                    Demo.increaseStepByOne();
                    httpSession.setAttribute("demoSession", Demo.getStep());
                    model.addAttribute("questionSetForCT", questionSetForCT);
                    return "questionSets/questionSetCT";
                }
                case "X-RAY": {
                    QuestionForm questionForm = new QuestionForm();
                    if (backToPage != null) {
                        questionForm.setBackToPage(backToPage);
                    }
                    QuestionSetForXRAY questionSetForXRAY = new QuestionSetForXRAY();

                    questionForm.setQuestionSetForXRAY(questionSetForXRAY);
                    questionSetForXRAY.setQuestionForm(questionForm);
                    questionForm.setConcept(conceptNew);
                    conceptNew.setQuestionForm(questionForm);

                    conceptService.save(conceptNew);
                    Demo.increaseStepByOne();
                    httpSession.setAttribute("demoSession", Demo.getStep());
                    model.addAttribute("questionSetForXRAY", questionSetForXRAY);
                    //model.addAttribute("conceptNew", conceptNew);
                    return "questionSets/questionSetXRAY";
                }
            }
            /******************************/
        }

        conceptService.save(conceptNew);

        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());


        if (backToPage != null) {
            return "redirect:"+backToPage;
        }

        return "redirect:/users/details/"+conceptNew.getAuthor().getId();
    }

    @GetMapping("/demoStepNumber10")
    public String demoStepNumber10(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/logout";
    }

    @GetMapping("/demoStepNumber11")    // login as designer
    public String demoStepNumber11(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/login?guest=designer";
    }

    @GetMapping("/demoStepNumber12")    // redirect to all projects page
    public String demoStepNumber12(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/all";
    }

    @GetMapping("/demoStepNumber13/{projectId}")    // go to demo project
    public String demoStepNumber13(
            @PathVariable("projectId") Long projectId,
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/details/"+projectId;
    }

    // set designer - assign me to the project
    @GetMapping("/demoStepNumber14/{conceptId}/{designerId}")
    public String demoStepNumber14(
            @PathVariable("conceptId") Long conceptId,
            @PathVariable("designerId") Long designerId,
            @RequestParam(name = "backToPage", required = true) String backToPage,
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/concepts/setDesigner/"+conceptId+"/"+designerId+"?backToPage="+backToPage;
    }

    // set status as finished
    @GetMapping("/demoStepNumber15/{conceptId}")
    public String demoStepNumber15(
            @PathVariable("conceptId") Long conceptId,
            @RequestParam("backToPage") String backToPage,
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        //concepts/setStatusFinished/${concept.id}?backToPage=projects/details/${project.id}
        return "redirect:/concepts/setStatusFinished/"+conceptId+"?backToPage="+backToPage;
    }

    @GetMapping("/demoStepNumber16")
    public String demoStepNumber16(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/logout";
    }

    @GetMapping("/demoStepNumber17")
    public String demoStepNumber17(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/login?guest=projectManager";
    }
    
    @GetMapping("/demoStepNumber18")
    public String demoStepNumber18(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/all";
    }

    @GetMapping("/demoStepNumber19/{projectId}")    // go to demo project
    public String demoStepNumber19(
            @PathVariable("projectId") Long projectId,
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/details/"+projectId;
    }

    @GetMapping("/demoStepNumber20/{conceptId}/{designerId}")
    public String demoStepNumber20(
            @PathVariable("conceptId") Long conceptId,
            @PathVariable("designerId") Long designerId,
            @RequestParam(name = "backToPage") String backToPage,
            HttpSession httpSession, Model model
    ) {
//        Concept conceptNew = new Concept();
//        if (userId != null) {
//            conceptNew.setAuthor(userService.loadById(userId));
//        }
//        if (projectId != null) {
//            conceptNew.setProject(projectService.loadById(projectId));
//        }
//        model.addAttribute("conceptNew", conceptNew);
        Concept concept = conceptService.loadByIdWithAll(conceptId);
        Guideline guidelineNew = new Guideline();
        guidelineNew.setConcept(concept);
        guidelineNew.setAuthor(concept.getAuthor());
        guidelineNew.setClient(concept.getClient());
        guidelineNew.setDevice(concept.getDevice());
        model.addAttribute("guidelineNew", guidelineNew);
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/guidelines/new/?conceptId="+conceptId+"&backToPage="+backToPage;
    }

    @PostMapping("/demoStepNumber21")
    public String demoStepNumber21(
            @RequestParam(name = "backToPage", required = false) String backToPage,
            @ModelAttribute("guidelineNew") @Valid Guideline guidelineNew,
            BindingResult result,
            HttpSession httpSession
    ) {
            if (result.hasErrors()) {
                return "orders/guidelines/new";
            }
            guidelineService.save(guidelineNew);
            Long conceptId = guidelineNew.getConcept().getId();
            Long projectId = conceptService.loadById(conceptId).getProject().getId();
            if (backToPage != null) {
                return "redirect:/"+backToPage;
            }
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/details/"+projectId;
    }

    @GetMapping("/demoStepNumber22")
    public String demoStepNumber22(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/logout";
    }

    @GetMapping("/demoStepNumber23")
    public String demoStepNumber23(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/login?guest=designer";
    }

    @GetMapping("/demoStepNumber24")
    public String demoStepNumber24(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/all";
    }

    @GetMapping("/demoStepNumber25/{projectId}")
    public String demoStepNumber25(
            @PathVariable("projectId") Long projectId,
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/projects/details/"+projectId;
    }

    @GetMapping("/demoStepNumber26/{guidelineId}/{userLoggedInId}")
    public String demoStepNumber26 (
            @PathVariable Long guidelineId,
            @PathVariable Long userLoggedInId,
            @RequestParam("backToPage") String backToPage,
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/guidelines/setDesigner/"+guidelineId+"/"+userLoggedInId+"?backToPage="+backToPage;
    }

    @GetMapping("/demoStepNumber27/{guidelineId}")
    public String demoStepNumber27(
            @PathVariable Long guidelineId,
            @RequestParam String backToPage,
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/guidelines/setStatusFinished/"+guidelineId+"?backToPage="+backToPage;
    }

    @GetMapping("/demoStepNumber28")
    public String demoStepNumber28(
            HttpSession httpSession
    ) {
        Demo.increaseStepByOne();
        httpSession.setAttribute("demoSession", Demo.getStep());
        return "redirect:/logout";
    }

}
