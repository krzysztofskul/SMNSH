package pl.krzysztofskul;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.krzysztofskul.email.EmailCredentials;
import pl.krzysztofskul.email.EmailSMNSH;
import pl.krzysztofskul.email.EmailSMNSHService;
import pl.krzysztofskul.email.EmailServiceImpl;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    /**
     * params.
     */
    private UserService userService;
    private EmailServiceImpl emailService;
    private EmailSMNSHService emailSMNSHService;

    /**
     * constr.
     */
    @Autowired
    public LoginController(UserService userService, EmailServiceImpl emailService, EmailSMNSHService emailSMNSHService) {
        this.userService = userService;
        this.emailService = emailService;
        this.emailSMNSHService = emailSMNSHService;
    }

    /**
     * getters and setters
     */

    /**
     * methods
     * @return
     */

    @ModelAttribute("userBusinessPositionList")
    public UserBusinessPosition[] getUserBusinessPositionList() {
        return UserBusinessPosition.values();
    }

    @GetMapping("/login")
    public String login(
            @RequestParam(value = "guest", required = false) String guest,
            HttpSession session
    ) {
        if (guest != null) {
            switch (guest) {
                case "admin": {
                    User user = userService.loadByEmail("Nameguest.Surname-Admin@test.test");
                    session.setAttribute("userLoggedIn", user);
                    return "redirect:/";
                }
                case "designer": {
                    User user = userService.loadByEmail("Name1Surname1@test.test");
                    session.setAttribute("userLoggedIn", user);
                    return "redirect:/";
                }
                case "projectManager": {
                    User user = userService.loadByEmail("Name3Surname3@test.test");
                    session.setAttribute("userLoggedIn", user);
                    return "redirect:/";
                }
            }
        }
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

    @GetMapping("/register")
    public String register(
            Model model
    ) {
        model.addAttribute("user", new User());
        return "/users/new";
    }
    @PostMapping("/register")
    public String register(
            @ModelAttribute("user") @Valid User user, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/users/new";
        }
        userService.save(user);
        emailService.sendHtmlMessage(user.getEmail(), "REGISTRATION ACCEPTED", "LOREM IPSUM SMSNSH APP.");
        return "redirect:/";
    }

    @GetMapping("/permissionDenied")
    public String permissionDenied() {
        return "permissionDenied";
    }

    @GetMapping("/admin/controlpanel")
    public String adminControlPanel(
            Model model
    ) {
        EmailSMNSH emailSMNSH = new EmailSMNSH();
        emailSMNSH.setEmail("smnshapp@gmail.com");
        model.addAttribute("listEmailSMNSH", emailSMNSHService.getAllEmailSMNSHEntity());
        model.addAttribute("emailSMNSH", emailSMNSH);
        return "admin/controlpanel";
    }
    @PostMapping("/admin/controlpanel")
    public String adminControlPanel(
            @ModelAttribute("emailSMNSH") EmailSMNSH emailSMNSH
    ) {
        EmailCredentials.getEmailCredentialsInstance().setPassPlain(emailSMNSH.getPassword());
        String passBcrypted = BCrypt.hashpw(emailSMNSH.getPassword(), BCrypt.gensalt());
        emailSMNSH.setPassword(passBcrypted);
        emailSMNSHService.save(emailSMNSH);
        return "redirect:/admin/controlpanel";
    }

}
