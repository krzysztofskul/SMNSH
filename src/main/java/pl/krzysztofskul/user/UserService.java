package pl.krzysztofskul.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    /**
     * params.
     */

    private UserRepo userRepo;

    /**
     * constr.
     * @param userRepo
     */
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * methods CRUD
     * */

    /*** Create */

    public void save(User user) {
        userRepo.save(user);
    }

    /*** Read */

    public List<User> loadAll() {
        return userRepo.findAll();
    }

    public User loadById(Long id) {
        return userRepo.findById(id).get();
    }

    /*** Update*/

    /*** Delete */
}
