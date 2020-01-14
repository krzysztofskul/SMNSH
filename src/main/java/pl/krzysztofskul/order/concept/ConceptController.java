package pl.krzysztofskul.order.concept;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.order.Status;
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
    @ModelAttribute("devicesAll")
    public List<Device> getDevicesAll() {
        return deviceService.loadAll();
    }

    @ModelAttribute("orderStatuses")
    public Status[] getOrderStatuses() {
        return Status.values();
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
        Concept concept = conceptService.loadByIdWithAll(id);
        model.addAttribute("concept", concept);
        return "orders/concepts/details";
    }

    /** CRUD methods: CREATE */

    @GetMapping("/new")
    public String conceptsNew(
            @RequestParam(name = "userId", required = false) Long userId,
            Model model
    ) {
        Concept conceptNew = new Concept();
        if (userId != null) {
            conceptNew.setAuthor(userService.loadById(userId));
        }
        model.addAttribute("conceptNew", conceptNew);
        return "orders/concepts/new";
    }
    @PostMapping("/new")
    public String conceptNew(
            @ModelAttribute("conceptNew") Concept conceptNew
    ) {
        conceptService.save(conceptNew);
//        return "redirect:/concepts/all";
        return "redirect:/users/"+conceptNew.getAuthor().getId()+"/details";
    }

    /** CRUD methods: UPDATE */

    @GetMapping("/edit/{id}")
    public String conceptsEditById(
            @PathVariable("id") Long id,
            Model model
    ) {
        Concept concept = conceptService.loadById(id);
        Hibernate.initialize(concept);
        model.addAttribute("concept", concept);
        return "orders/concepts/edit";
    }
    @PostMapping("/edit/{id}")
    public String conceptsEditById(
            @PathVariable("id") Long id,
            @ModelAttribute("concept") Concept concept
    ) {
        conceptService.save(concept);
        return "redirect:/concepts/details/"+id;
    }

    @GetMapping("/{id}/setDesigner")
    public String setDesigner(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("concept", conceptService.loadById(id));
        model.addAttribute("usersDesigners", userService.loadAllDesigners());
        return "orders/concepts/setDesigner";
    }
    @PostMapping("/{id}/setDesigner")
    public String setDesigner (
            @ModelAttribute("concept") Concept concept
    ) {
        conceptService.save(concept);
        return "redirect:/concepts/all";
    }

    @GetMapping("/{id}/setStatus")
    public String setStatus() {
        return "orders/concepts/setStatus";
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