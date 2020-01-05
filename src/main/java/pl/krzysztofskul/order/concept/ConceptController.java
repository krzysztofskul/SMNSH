package pl.krzysztofskul.order.concept;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/concepts")
public class ConceptController {

    /**
     * p.
     */

    private ConceptService conceptService;
    private DeviceService deviceService;
    private UserService userService;

    /**
     * c.
     */
    @Autowired
    public ConceptController(
            ConceptService conceptService,
            DeviceService deviceService,
            UserService userService
    ) {
        this.conceptService = conceptService;
        this.deviceService = deviceService;
        this.userService = userService;
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

    /** CRUD methods: READ */

    @GetMapping("/all")
    public String conceptsAll(
            Model model
    ) {
        model.addAttribute("conceptsAll", conceptService.loadAll());
        return "orders/concepts/all";
    }

    @GetMapping("/details/{id}")
    public String conceptsDetailsById(
            Model model,
            @PathVariable("id") Long id
    ) {
        Concept concept = conceptService.loadById(id);
        Hibernate.initialize(concept);  // todo?: move to ConceptService
        model.addAttribute("concept", concept);
        return "orders/concepts/details";
    }

    /** CRUD methods: CREATE */

    @GetMapping("/new")
    public String conceptsNew(
            Model model
    ) {
        Concept conceptNew = new Concept();
        model.addAttribute("conceptNew", conceptNew);
        model.addAttribute("devicesAll", deviceService.loadAll());
        return "orders/concepts/new";
    }
    @PostMapping("/new")
    public String conceptNew(
            @ModelAttribute("conceptNew") Concept conceptNew
    ) {
        conceptService.save(conceptNew);
        return "redirect:/concepts/all";
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