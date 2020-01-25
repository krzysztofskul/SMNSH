package pl.krzysztofskul.user;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.user.avatar.AvatarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * p.
     */

    private UserService userService;
    private AvatarService avatarService; //todo?: del

    /**
     * c.
     */
    public UserController(UserService userService,
                          AvatarService avatarService
    ) {
        this.userService = userService;
        this.avatarService = avatarService;
    }

    /**
     * g&s
     */

    /**
     * m.
     */
    /** @ModelAttributes
     *
     * @return
     */
    @ModelAttribute("userBusinessPositionList")
    public UserBusinessPosition[] getUserBusinessPositionList() {
        return UserBusinessPosition.values();
    }

    /** crud CREATE */
    @GetMapping("/new")
    public String newUser(
            Model model
    ) {
        model.addAttribute("user", new User());
        return "/users/new";
    }
    @PostMapping("/new")
    public String newUser(
            @ModelAttribute("user") @Valid User user, BindingResult result,
            Model model //, HttpSession session
    ) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                if (error.getDefaultMessage().equals("Potwierdź hasło / Confirm the password!")) {
                    model.addAttribute("errorPasswordConfirm", "true");
                    //session.setAttribute("errorPasswordConfirm", "true");
                }
            }
            return "users/new";
        }
        userService.save(user);
        model.addAttribute("errorPasswordConfirm", "false");
        return "redirect:/users/all";
    }

    /** crud READ */
    @GetMapping("/all")
    public String usersAll(
            Model model
    ) {
        List<User> usersAll = userService.loadAll();
        model.addAttribute("usersAll", usersAll);
        model.addAttribute("errorPasswordConfirm", "false");

        /* laod avatars from DB */
        //todo?: move to UserService
//        for (User user : usersAll) {
//            if (user.getAvatar() != null) {
                //byte[] byteAvatar = user.getAvatar().getData();
//                avatarService.loadById(user.getId());
                //try {
                    //FileOutputStream fileOutputStream = new FileOutputStream("/resources/img/avatars/usersAll/"+user.getAvatar().getId()+".png");
//                    FileOutputStream fileOutputStream = new FileOutputStream("/resources/img/avatars/usersAll/1.png");
//                    FileOutputStream fileOutputStream = new FileOutputStream("src/main/webapp/resources/img/avatars/usersAll/"+user.getAvatar().getId()+".png");
                    //fileOutputStream.write(byteAvatar);
                    //fileOutputStream.close();

                //} catch (Exception e) {
                    //e.printStackTrace();
                //}
//            }
//        }

        return "users/all";
    }

//    @GetMapping("/{id}/details")
    @GetMapping("/details/{id}")
    public String details(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("user", userService.loadByIdWithConceptList(id));
        model.addAttribute("businessPositions", UserBusinessPosition.values());
        return "users/details";
    }

    /** crud UPDATE */

    @PostMapping("/details/{id}")
    public String details(
            @PathVariable("id") Long id,
            @ModelAttribute("user") @Valid User user, BindingResult result,
            HttpSession session, Model model
            //todo: user's avatar //@RequestParam("file") MultipartFile multipartFile
    ) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                if (error.getDefaultMessage().equals("{pl.krzysztofskul.validator.UniqueEmail.message}") && errors.size() == 1) {
                    User userLoggedIn = (User) session.getAttribute("userLoggedIn");
                    if (user.getEmail().equals(userLoggedIn.getEmail())) {
                        userService.save(user);
                        return "redirect:/users/details/"+id;
                    }
                }
            }
            model.addAttribute("user", user);
            model.addAttribute("businessPositions", UserBusinessPosition.values());
//            return "redirect:/users/"+id+"/details";
            return "users/details";
        }
        userService.save(user);
        /* //todo: user's avatar
        User userEdited = userService.loadById(id);
        userEdited.setAvatar(avatarService.save(multipartFile));
        userService.save(userEdited);*/
//        return "redirect:/users/all";
        return "redirect:/users/details/"+id;
    }

    /** crud DELETE */
}
