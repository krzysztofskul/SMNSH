package pl.krzysztofskul.order.concept;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.device.category.DeviceCategoryService;
import pl.krzysztofskul.device.prototype.Prototype;
import pl.krzysztofskul.device.prototype.PrototypeService;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.project.StatusProject;
import pl.krzysztofskul.questionnaire.*;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForCT;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForMRI;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForXRAY;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/concepts")
public class ConceptController {

    /**
     * p.
     */

    private ConceptService conceptService;
    private DeviceService deviceService;
    private PrototypeService prototypeService;
    private DeviceCategoryService deviceCategoryService;
    private UserService userService;
    private ProjectService projectService;

    /**
     * c.
     */
    @Autowired
    public ConceptController(
            ConceptService conceptService,
            DeviceService deviceService,
            PrototypeService prototypeService,
            DeviceCategoryService deviceCategoryService,
            UserService userService,
//            QuestionFormService questionFormService,
            ProjectService projectService
    ) {
        this.conceptService = conceptService;
        this.deviceService = deviceService;
        this.prototypeService = prototypeService;
        this.deviceCategoryService = deviceCategoryService;
        this.userService = userService;
//        this.questionFormService = questionFormService;
        this.projectService = projectService;
    }

    /**
     * g&s
     */

    /**
     * m.
     */

    /** @ModelAttributes */
    @ModelAttribute("usersAll")
    public List<User> getUsersAll() {
        return userService.loadAll();
    }
    @ModelAttribute("devicesAll")
    public List<Device> getDevicesAll() {
        return deviceService.loadAll();
    }
    
    @ModelAttribute("prototypesAll")
    public List<Prototype> getPrototypesAll() {
        return prototypeService.loadAll();
    }
    
    public List<DeviceCategory> getDeviceCategoryAll() {
        return deviceCategoryService.loadAll();
    }
    @ModelAttribute("orderStatuses")
    public Status[] getOrderStatuses() {
        return Status.values();
    }

    /** CRUD methods: READ */

    @GetMapping("/all")
    public String conceptsAll(
            @RequestParam(value = "filter", required = false, defaultValue = "all") String filter,
            Model model
    ) {
        if (filter.equals("all")) {
            model.addAttribute("conceptsAll", conceptService.loadAll());
        } else if (filter.equals("waiting")) {
            model.addAttribute("conceptsAll", conceptService.findAllByStatusOrderByDateTimeDeadlineAsc(Status.ORDERED_WAITING));
        } else if (filter.equals("inProgress")) {
            model.addAttribute("conceptsAll", conceptService.findAllByStatusOrderByDateTimeDeadlineAsc(Status.IN_PROGRESS));
        } else if (filter.equals("finished")) {
            model.addAttribute("conceptsAll", conceptService.loadAllByStatus(Status.FINISHED));
        }
        return "orders/concepts/all";
    }
    @GetMapping("/details/{id}")
    public String conceptsDetailsById(
            Model model,
            @PathVariable("id") Long id,
            @RequestParam(name = "conceptListPage", required = false) String conceptListPage
    ) {

        if (conceptListPage != null && conceptListPage.equals("true")) {
            List<Concept> conceptList = conceptService.loadAllByUserId(id);
            model.addAttribute("conceptList", conceptList);
            return "users/orders";
        }

        Concept concept = conceptService.loadByIdWithAll(id);
        model.addAttribute("concept", concept);
        return "orders/concepts/details";
    }

    /** CRUD methods: CREATE */

    @GetMapping("/new")
    public String conceptsNew(
            @RequestParam(name = "userId", required = false) Long userId,
            @RequestParam(name = "projectId", required = false) Long projectId,
            @RequestParam(name = "deviceId", required = false) Long deviceId,
            @RequestParam(name = "backToPage", required = false) String backToPage,
            Model model
    ) {
        Concept conceptNew = new Concept();
        if (userId != null) {
            conceptNew.setAuthor(userService.loadById(userId));
            model.addAttribute("projectList", projectService.loadAllByProjectManager(userService.loadById(userId)));
        }
        if (projectId != null) {
            conceptNew.setProject(projectService.loadByIdWithDeviceList(projectId));
        }
        if (deviceId != null) {
        	//conceptNew.setDevice(deviceService.loadById(deviceId));
        	conceptNew.setPrototype(prototypeService.loadById(deviceId));
        }
        if (backToPage != null) {
            model.addAttribute("backToPage", backToPage);
        }
        model.addAttribute("conceptNew", conceptNew);
        return "orders/concepts/new";
    }
    
    @PostMapping("/new")
    public String conceptNew(
            @ModelAttribute("conceptNew") @Valid Concept conceptNew,
            @RequestParam(name = "backToPage", required = false) String backToPage,
            BindingResult result,
            Model model
    )
    {
        if (result.hasErrors()) {
            return "orders/concepts/new";
        }

        if (conceptNew.getQuestionForm() == null) {
            /****************************
             * ADDITION QUESTION SET REDIRECT (DEPENDS ON DEVICE CATEGORY)
             */
            Prototype device = prototypeService.loadById(conceptNew.getPrototype().getId());
            //Hibernate.initialize(device.getDeviceCategory());
            /*
            switch (device.getModality()) {
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
                    model.addAttribute("questionSetForXRAY", questionSetForXRAY);
                    //model.addAttribute("conceptNew", conceptNew);
                    return "questionSets/questionSetXRAY";
                }
                default: {
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
                    model.addAttribute("questionSetForXRAY", questionSetForXRAY);
                    //model.addAttribute("conceptNew", conceptNew);
                    return "questionSets/questionSetXRAY";
                }
               
            }
            /*
            /******************************/
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
            model.addAttribute("questionSetForXRAY", questionSetForXRAY);
            //model.addAttribute("conceptNew", conceptNew);
            return "questionSets/questionSetXRAY";
        }

        conceptService.save(conceptNew);

        if (backToPage != null) {
            return "redirect:"+backToPage;
        }

        return "redirect:/users/details/"+conceptNew.getAuthor().getId();
    }

    /** CRUD methods: UPDATE */

    @GetMapping("/edit/{id}")
    public String conceptsEditById(
            @PathVariable("id") Long id,
            Model model
    ) {
        Concept concept = conceptService.loadById(id);
        model.addAttribute("concept", concept);
        return "orders/concepts/edit";
    }
    @PostMapping("/edit/{id}")
    public String conceptsEditById(
            @PathVariable("id") Long id,
            @ModelAttribute("concept") @Valid Concept concept, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/concepts/edit/"+id;
        }
        if (concept.getAdditionalRoomsToDesign().length() == 0) {
            concept.setAdditionalRoomsToDesign(null);
        }
        if (concept.getCustomerSuggestions().length() == 0) {
            concept.setCustomerSuggestions(null);
        }
        if (concept.getStatus() == Status.FINISHED || concept.getStatus() == Status.ORDERED_WAITING) {
            concept.setPlanner(null);
        }
        if (concept.getPlanner() != null) {
            if (concept.getPlanner().getId() == 0) {
                concept.setPlanner(null);
            }
        }
        conceptService.save(concept);
        return "redirect:/concepts/details/"+id;
    }

    @GetMapping("/setDesigner/{conceptId}")
    public String setDesigner(
            @PathVariable("conceptId") Long conceptId,
            Model model
    ) {
        model.addAttribute("concept", conceptService.loadById(conceptId));
        model.addAttribute("usersDesigners", userService.loadAllDesigners());
        return "orders/concepts/setDesigner";
    }
    @GetMapping("/setDesigner/{conceptId}/{designerId}")
    public String setDesigner(
            @PathVariable("conceptId") Long conceptId,
            @PathVariable("designerId") Long designerID,
            @RequestParam(name = "backToPage", required = true) String backToPage
    ) {
        Concept concept = conceptService.loadById(conceptId);
        Project project = concept.getProject();
        concept.setPlanner(userService.loadById(designerID));
        project.setDes(userService.loadById(designerID));
        concept.setStatus(Status.IN_PROGRESS);
        conceptService.save(concept);
        projectService.save(project);
        return "redirect:/"+backToPage;
    }

    @PostMapping("/setDesigner/{plannerId}")
    public String setDesigner (
            @PathVariable Long plannerId,
            @ModelAttribute("concept") Concept concept
    ) {
        concept.setStatus(Status.IN_PROGRESS);
        concept.setPlanner(userService.loadById(plannerId));
        conceptService.save(concept);
        Project project = projectService.loadById(concept.getProject().getId());
        project.setDes(userService.loadById(plannerId));
        projectService.save(project);
        return "redirect:/concepts/all?filter=all";
    }

    @GetMapping("/setStatus/{id}")
    public String setStatus(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("concept", conceptService.loadByIdWithAll(id));
        return "orders/concepts/setStatus";
    }
    @GetMapping("/setStatusFinished/{conceptId}")
    public String setStatusFinished(
            @PathVariable("conceptId") Long conceptId,
            @RequestParam(name = "backToPage", required = true) String backToPage
    ) {
        Concept concept = conceptService.loadById(conceptId);
        concept.setStatus(Status.FINISHED);
        concept.setPlanner(null);
        conceptService.save(concept);
        return "redirect:/"+backToPage;
    }

    @PostMapping("/setStatus/{id}")
    public String setStatus(
            @ModelAttribute("concept") Concept concept
    ) {
        if (concept.getStatus() == Status.ORDERED_WAITING || concept.getStatus() == Status.FINISHED) {
            concept.setPlanner(null);
        }
        conceptService.save(concept);
        return "redirect:/concepts/all?filter=all";
    }

    /** CRUD methods: DELETE */

    @GetMapping("/delete/{id}")
    public String conceptsDeleteById(
            @PathVariable("id") Long id
    ) {
        conceptService.deleteById(id);
        return "redirect:/concepts/all";
    }
}