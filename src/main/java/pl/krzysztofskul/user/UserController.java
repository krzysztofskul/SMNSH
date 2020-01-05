package pl.krzysztofskul.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * p.
     */

    private UserService userService;

    /**
     * c.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * g&s
     */

    /**
     * m.
     */

    @GetMapping("/all")
    public String usersAll(
            Model model
    ) {
        model.addAttribute("usersAll", userService.loadAll());
        return "users/all";
    }

}
