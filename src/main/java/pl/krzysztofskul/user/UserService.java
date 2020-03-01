package pl.krzysztofskul.user;

import org.hibernate.Hibernate;
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

    public List<User> loadAllDesigners() {
        return userRepo.findAllByBusinessPosition(UserBusinessPosition.PLANNER);
    }

    public List<User> loadAllProjectManagers() {
        return userRepo.findAllByBusinessPosition(UserBusinessPosition.PROJECT_MANAGER);
    }

    public User loadById(Long id) {
        return userRepo.findById(id).get();
    }

    public User loadByIdWithConceptList(Long id) {
        User user = userRepo.findById(id).get();
        Hibernate.initialize(user.getConceptList());
        return user;
    }

    public User loadByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public boolean isExistent(String value) {
        List<User> userList = userRepo.findAll();

        if (userList.size() != 0) {
            for (User user : userList) {
                if (user.getEmail().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    /*** Update*/

    /*** Delete */
}
