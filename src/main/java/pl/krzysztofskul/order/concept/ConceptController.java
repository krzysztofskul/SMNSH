package pl.krzysztofskul.order.concept;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
            @ModelAttribute("conceptNew") @Valid Concept conceptNew,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "orders/concepts/new";
        }
        conceptService.save(conceptNew);
//        return "redirect:/concepts/all";
        return "redirect:/users/details/"+conceptNew.getAuthor().getId();
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
            @ModelAttribute("concept") @Valid Concept concept, BindingResult result
//            @RequestParam(value = "inputDateDeadline", required = false) Date date
    ) {
        if (result.hasErrors()) {
            return "redirect:/concepts/edit/"+id;
        }
//        LocalDate localDate = date.toLocalDate();
//        LocalDateTime localDateTime = localDate.atTime(0,0,0);
//        concept.setDateTimeDeadline(localDateTime);
        if (concept.getAdditionalRoomsToDesign().length() == 0) {
            concept.setAdditionalRoomsToDesign(null);
        }
        if (concept.getCustomerSuggestions().length() == 0) {
            concept.setCustomerSuggestions(null);
        }
        if (concept.getStatus() == Status.FINISHED) {
            concept.setPlanner(null);
        }
        if (concept.getPlanner().getId() == 0) {
            concept.setPlanner(null);
        }
        conceptService.save(concept);
        return "redirect:/concepts/details/"+id;
    }

    @GetMapping("/setDesigner/{id}")
    public String setDesigner(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("concept", conceptService.loadById(id));
        model.addAttribute("usersDesigners", userService.loadAllDesigners());
        return "orders/concepts/setDesigner";
    }
    @PostMapping("/setDesigner/{id}")
    public String setDesigner (
            @ModelAttribute("concept") Concept concept
    ) {
        concept.setStatus(Status.IN_PROGRESS);
        conceptService.save(concept);
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
    @PostMapping("/setStatus/{id}")
    public String setStatus(
            @ModelAttribute("concept") Concept concept
    ) {
        if (concept.getStatus() == Status.FINISHED) {
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