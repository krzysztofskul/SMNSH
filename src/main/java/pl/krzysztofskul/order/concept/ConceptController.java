package pl.krzysztofskul.order.concept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysztofskul.device.DeviceService;

@Controller
@RequestMapping("/concepts")
public class ConceptController {

    /**
     * p.
     */

    private ConceptService conceptService;
    private DeviceService deviceService;

    /**
     * c.
     */
    @Autowired
    public ConceptController(
            ConceptService conceptService,
            DeviceService deviceService
    ) {
        this.conceptService = conceptService;
        this.deviceService = deviceService;
    }

    /**
     * g&s
     */

    /**
     * m.
     */

    @GetMapping("/all")
    public String conceptsAll(
            Model model
    ) {
        model.addAttribute("conceptsAll", conceptService.loadAll());
        return "orders/concepts/all";
    }

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
    public String conceptNew() {
        return "redirect:/concepts/all";
    }
}