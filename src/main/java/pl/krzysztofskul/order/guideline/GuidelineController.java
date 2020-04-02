package pl.krzysztofskul.order.guideline;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/guidelines")
public class GuidelineController {

    /**
     * p.
     */
    private GuidelineService guidelineService;
    private UserService userService;
    private ConceptService conceptService;

    /**
     * c.
     */
    public GuidelineController(
            GuidelineService guidelineService,
            UserService userService,
            ConceptService conceptService
    ) {
        this.guidelineService = guidelineService;
        this.userService = userService;
        this.conceptService = conceptService;
    }
    /**
     * g&s
     */

    /**
     * m.
     */

    /** @ModelAttributes */
    @ModelAttribute("usersAll")
    public List<User> getUserList() {
        return userService.loadAll();
    }

    /** CRUD Create */
    @GetMapping("/new")
    public String newGuideline(
            @RequestParam("conceptId") Long conceptId,
//            @RequestParam(name = "backToPage", required = false) String backToPage,
            Model model
    ) {
        Concept concept = conceptService.loadByIdWithAll(conceptId);
        Guideline guidelineNew = new Guideline();
        guidelineNew.setConcept(concept);
        guidelineNew.setAuthor(concept.getAuthor());
        guidelineNew.setClient(concept.getClient());
        guidelineNew.setDevice(concept.getDevice());
        model.addAttribute("guidelineNew", guidelineNew);
//        if (backToPage != null) {
//            model.addAttribute("backToPage", backToPage);
//        }
        return "orders/guidelines/new";
    }
    @PostMapping("/new")
    public String newGuideline(
            @RequestParam(name = "backToPage", required = false) String backToPage,
            @ModelAttribute("guidelineNew") @Valid Guideline guidelineNew,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "orders/guidelines/new";
        }
        guidelineService.save(guidelineNew);
        if (backToPage != null) {
            return "redirect:/"+backToPage;
        }
        return "redirect:/users/details/"+guidelineNew.getAuthor().getId();
    }

    /** CRUD Update */

    @GetMapping("/setDesigner/{guidelineId}/{userLoggedInId}")
    public String setDesigner(
            @PathVariable("guidelineId") Long guidelineId,
            @PathVariable("userLoggedInId") Long userLoggedInId,
            @RequestParam(name = "backToPage", required = false) String backToPage
    ) {
        Guideline guideline = guidelineService.loadById(guidelineId);
        guideline.setDesigner(userService.loadById(userLoggedInId));
        guideline.setStatus(Status.IN_PROGRESS);
        guidelineService.save(guideline);
        return "redirect:/"+backToPage;
    }

    @GetMapping("/setStatusFinished/{guidelineId}")
    public String setStatusFinished(
            @PathVariable("guidelineId") Long guidelineId,
            @RequestParam(name = "backToPage", required = false) String backToPage
    ) {
        Guideline guideline = guidelineService.loadById(guidelineId);
        guideline.setStatus(Status.FINISHED);
        guideline.setDesigner(null);
        guidelineService.save(guideline);
        return "redirect:/"+backToPage;
    }

    /** ERROR PAGE*/
    @GetMapping("/errorStatus")
    public String errorStatus() {
        return "orders/guidelines/errorStatus";
    }
}