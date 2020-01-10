package pl.krzysztofskul.user.avatar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AvatarController {

    /** p. */
    private AvatarService avatarService;
    /** c. */

    /** g&s */
    @Autowired
    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    /** m. */
    //todo: user's avatar
    /*@RequestMapping(value = "/avatars/{id}")
    @ResponseBody
    public byte[] avatar(@PathVariable("id") Long id) {
        return avatarService.loadById(id).getData();
    }*/

}