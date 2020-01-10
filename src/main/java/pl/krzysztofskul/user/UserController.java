package pl.krzysztofskul.user;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.user.avatar.AvatarService;

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

    /** crud CREATE */

    /** crud READ */
    @GetMapping("/all")
    public String usersAll(
            Model model
    ) {
        List<User> usersAll = userService.loadAll();
        model.addAttribute("usersAll", usersAll);

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

    @GetMapping("/{id}/details")
    public String details(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("user", userService.loadByIdWithConceptList(id));
        model.addAttribute("businessPositions", UserBusinessPosition.values());
        return "users/details";
    }

    /** crud UPDATE */

    @PostMapping("/{id}/details")
    public String details(
            @PathVariable("id") Long id,
            @ModelAttribute("user") User user
            //todo: user's avatar //@RequestParam("file") MultipartFile multipartFile
    ) {
        userService.save(user);
        /* //todo: user's avatar
        User userEdited = userService.loadById(id);
        userEdited.setAvatar(avatarService.save(multipartFile));
        userService.save(userEdited);*/
        return "redirect:/users/all";
    }

    /** crud DELETE */
}
