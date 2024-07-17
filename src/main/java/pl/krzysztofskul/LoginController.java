package pl.krzysztofskul;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.krzysztofskul.email.EmailCredentials;
import pl.krzysztofskul.email.EmailSMNSH;
import pl.krzysztofskul.email.EmailSMNSHService;
import pl.krzysztofskul.email.EmailServiceImpl;
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserAction;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.avatar.Avatar;
import pl.krzysztofskul.user.avatar.AvatarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import java.net.http.HttpRequest;
import java.time.LocalDateTime;

@Controller
public class LoginController {

    /**
     * params.
     */
    private UserService userService;
    private EmailServiceImpl emailService;
    private EmailSMNSHService emailSMNSHService;
    private AvatarService avatarService;
    private LoggerUserService<Object> loggerUserService;
    private EmailCredentials emailCredentials;

    /**
     * constr.
     */
    @Autowired
    public LoginController(
    		EmailCredentials emailCredentials,
            UserService userService,
            EmailServiceImpl emailService,
            EmailSMNSHService emailSMNSHService,
            AvatarService avatarService,
            LoggerUserService<Object> loggerUserService
    ) {    	
    	this.emailCredentials = emailCredentials;
        this.userService = userService;
        this.emailService = emailService;
        this.emailSMNSHService = emailSMNSHService;
        this.avatarService = avatarService;
        this.loggerUserService = loggerUserService;
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
        	User user = new User();
            switch (guest) 
            {
                case "admin": {
                    user = userService.loadByEmail("piotr.w@test.test");
                    break;
                }
                case "admin-pw": {
                    user = userService.loadByEmail("piotr.w@test.test");
                    break;
                }
                case "admin-ms": {
                	user = userService.loadByEmail("magdalena.s@test.test");
                	break;
                }
                case "designer-md": {
                    user = userService.loadByEmail("maciej.d@test.test");
                    break;
                }
                case "designer-kk": {
                	user = userService.loadByEmail("krzysztof.k@test.test");
                	break;
                }
                case "designer-kd": {
                	user = userService.loadByEmail("karol.d@test.test");
                	break;
                }
                case "projectManager-sk": {
                    user = userService.loadByEmail("sebastian.k@test.test");
                    break;
                }
                case "projectManager-ewm": {
                	user = userService.loadByEmail("ewa.w-m@test.test");
                	break;
                }
                case "projectManager-hs": {
                	user = userService.loadByEmail("henryk.s@test.test");
                	break;
                }
                case "projectManager-sr": {
                	user = userService.loadByEmail("sebastian.r@test.test");
                	break;
                }
                case "projectManager-ss": {
                	user = userService.loadByEmail("sebastian.s@test.test");
                	break;
                }
                case "projectManager-ks": {
                	user = userService.loadByEmail("kamil.s@test.test");
                	break;
                }
                case "projectManager-wp": {
                	user = userService.loadByEmail("wojciech.p@test.test");
                	break;
                }
                case "projectManager-ao": {
                	user = userService.loadByEmail("arkadiusz.o@test.test");
                	break;
                }
                case "projectManager-ps": {
                	user = userService.loadByEmail("piotr.s@test.test");
                	break;
                }
                case "projectManager-ks2": {
                	user = userService.loadByEmail("krzysztof.s@test.test");
                	break;
                }
                case "projectManager-mjb": {
                	user = userService.loadByEmail("marika.j-b@test.test");
                	break;
                }
                case "projectManager-mc": {
                	user = userService.loadByEmail("mateusz.c@test.test");
                	break;
                }
                case "projectManager-jn": {
                	user = userService.loadByEmail("jaroslaw.n@test.test");
                	break;
                }
                case "projectManager-eb": {
                	user = userService.loadByEmail("emilia.b@test.test");
                	break;
                }                
                case "salesRep-wg": {
                    user = userService.loadByEmail("wojciech.g@test.test");
                    break;
                }
                case "salesRep-rg": {
                	user = userService.loadByEmail("ryszard.g@test.test");
                	break;
                }
        	}
            	session.setAttribute("userLoggedIn", user);
            	loggerUserService.log(user, LocalDateTime.now(), UserAction.LOG_IN, null);
            	return "redirect:/";
        }
        return "login";
    }
    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            HttpServletRequest httpServletRequest
    ) {
        User user = userService.loadByEmail(email);
        if (user == null) {
            return "login";
        }
        if (user.checkPassword(password)) {
            session.setAttribute("userLoggedIn", user);
            loggerUserService.log(user, LocalDateTime.now(), UserAction.LOG_IN, httpServletRequest.getHeader("User-Agent"));
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
            //@RequestParam(name = "avatarUpload") MultipartFile avatarUpload,
            @ModelAttribute("user") @Valid User user, BindingResult result
    ) {
//        if (result.hasErrors()) {
//            return "/users/new";
//        }
        // TEST
//        if (avatarUpload != null) {
//            avatarService.save(avatarUpload);
//            Avatar avatar = avatarService.loadById(Long.parseLong("2"));
//            user.setAvatar(avatar);
//        }
        User userSaved = userService.saveAndReturn(user);
        emailService.sendHtmlMessage(user.getEmail(), "REGISTRATION ACCEPTED", "LOREM IPSUM SMNSH APP.");
        loggerUserService.log(user, LocalDateTime.now(), UserAction.REGISTER, null);
        return "redirect:/add-avatar?userId="+userSaved.getId();
    }

    @GetMapping("/add-avatar")
    public String addAvatar(
    		//@PathVariable Long userId,
    		@RequestParam (name = "userId") Long userId,
    		HttpServletRequest httpServletRequest
    		) {
    	httpServletRequest.setAttribute("userId", userId);
    	return "/users/addAvatar";
    }
    
    @PostMapping("/add-avatar")
    public String addAvatar(
    		//@PathVariable Long userId,
    		@RequestParam (name = "userId") Long userId,
    			@RequestParam(name = "avatarUpload") MultipartFile avatarUpload
    		) {
    	
    	System.out.println("Avatar for userId "+ userId +" has been uploaded sucessfully.."+avatarUpload.getOriginalFilename());
    	Avatar avatar = avatarService.save(avatarUpload);
    	User user = userService.loadById(userId);
    	user.setAvatar(avatar);
    	userService.save(user);
    	System.out.println("User's avatar has been uptaded!");
    	
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
        if (emailCredentials.getPassPlain() == null) {
            EmailSMNSH emailSMNSH = new EmailSMNSH();
            emailSMNSH.setEmail(emailCredentials.getLogin());
            model.addAttribute("listEmailSMNSH", emailSMNSHService.getAllEmailSMNSHEntity());
            model.addAttribute("emailSMNSH", emailSMNSH);
            return "admin/controlpanel";
        } else {
            return "redirect:/permissionDenied";
        }
    }
    @PostMapping("/admin/controlpanel")
    public String adminControlPanel(
            @ModelAttribute("emailSMNSH") EmailSMNSH emailSMNSH,
            HttpSession httpSession
    ) {
        emailCredentials.setPassPlain(emailSMNSH.getPassword());
        String passBcrypted = BCrypt.hashpw(emailSMNSH.getPassword(), BCrypt.gensalt());
        emailSMNSH.setPassword(passBcrypted);
        emailSMNSHService.save(emailSMNSH);
        loggerUserService.log((User) httpSession.getAttribute("userLoggedIn"), LocalDateTime.now(), UserAction.EMAIL_CONFIGURATION, null);
        return "redirect:/admin/controlpanel";
    }

}
