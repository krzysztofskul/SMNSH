package pl.krzysztofskul.user.avatar;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
public class AvatarService {

    /** p. */
    private AvatarRepo avatarRepo;

    /** c. */
    public AvatarService(AvatarRepo avatarRepo) {
        this.avatarRepo = avatarRepo;
    }

    /** g&s */

    /** m. */
    //todo: user's avatar
    /*public void save(Avatar avatar) {
        avatarRepo.save(avatar);
    }*/
    /*public Avatar save(MultipartFile multipartFile){
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new RuntimeException("Invalid squence!");
            }
            Avatar avatar = new Avatar();
            avatar.setFileName(fileName);
            avatar.setFileType(multipartFile.getContentType());
            avatar.setData(multipartFile.getBytes());
            return avatarRepo.save(avatar);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't store the file! Try again.");
        }
    }*/


    public Avatar loadById(Long id) {
        return avatarRepo.findById(id).get();
    }

}
