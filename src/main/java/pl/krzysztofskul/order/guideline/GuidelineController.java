package pl.krzysztofskul.order.guideline;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.concept.ConceptService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

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
            Model model
    ) {
        Concept concept = conceptService.loadByIdWithAll(conceptId);
        Guideline guidelineNew = new Guideline();
        guidelineNew.setConcept(concept);
        guidelineNew.setAuthor(concept.getAuthor());
        guidelineNew.setClient(concept.getClient());
        guidelineNew.setDevice(concept.getDevice());
        model.addAttribute("guidelineNew", guidelineNew);
        return "orders/guidelines/new";
    }
    @PostMapping("/new")
    public String newGuideline(
            @ModelAttribute("guidelineNew") Guideline guidelineNew
    ) {
        guidelineService.save(guidelineNew);
        return "redirect:/users/details/"+guidelineNew.getAuthor().getId();
    }
}