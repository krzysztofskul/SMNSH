package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    /**
     * params.
     */
    private UserService userService;

    /**
     * constr.
     */
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * getters and setters
     */

    /**
     * methods
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session
    ) {
        User user = userService.loadByEmail(email);
        if (user == null) {
            return "login";
        }
        if (user.checkPassword(password)) {
            session.setAttribute("userLoggedIn", user);
        }
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(
            HttpSession session
    ) {
        session.setAttribute("userLoggedIn", null);
        return "redirect:/";
    }

}
