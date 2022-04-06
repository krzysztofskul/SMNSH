package pl.krzysztofskul.user;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    /**
     * params.
     */

	private List<User> userTestList = new ArrayList<User>();
	
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
     * getters and setters
     */
    
    	public List<User> getUserTestList() {
		return userTestList;
	}

	public void setUserTestList(List<User> userTestList) {
		this.userTestList = userTestList;
	}
    
    /**
     * methods CRUD
     * */

	/*** Create */

    public void save(User user) {
        userRepo.save(user);
    }
    
    public User saveAndReturn(User user) {
    	return userRepo.save(user);
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

    public List<User> loadAllSalesReps() {
        return userRepo.findAllByBusinessPosition(UserBusinessPosition.SALES_REP);
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
    
    /**
     * no-CRUD methods
     */
    
    public void createRealTestUsers() {
        userTestList.add(new User(
        		"Piotr", "W.", UserBusinessPosition.ADMIN, 
        		"piotr.w@test.test", "test"
        		));
        userTestList.add(new User(
        		"Sebastian", "K.", UserBusinessPosition.PROJECT_MANAGER, 
        		"sebastian.k@test.test", "test"
        		));
        userTestList.add(new User(
        		"Ewa", "W-M.", UserBusinessPosition.PROJECT_MANAGER, 
        		"ewa.w-m@test.test", "test"
        		));
        userTestList.add(new User(
        		"Henryk", "S.", UserBusinessPosition.PROJECT_MANAGER, 
        		"henryk.s@test.test", "test"
        		));
        userTestList.add(new User(
        		"Maciej", "D.", UserBusinessPosition.PLANNER, 
        		"maciej.d@test.test", "test"
        		));
        userTestList.add(new User(
        		"Krzysztof", "K.", UserBusinessPosition.PLANNER, 
        		"krzysztof.k@test.test", "test"
        		));
        userTestList.add(new User(
        		"Karol", "D.", UserBusinessPosition.PLANNER, 
        		"karol.d@test.test", "test"
        		));
        userTestList.add(new User(
        		"Wojciech", "G.", UserBusinessPosition.SALES_REP, 
        		"wojciech.g@test.test", "test"
        		));
        userTestList.add(new User(
        		"Ryszard", "G.", UserBusinessPosition.SALES_REP, 
        		"ryszard.g@test.test", "test"
        		));
    }
    
    
    public void saveRealTestUsersToDb() {
    	for (User user : this.getUserTestList()) {
			this.save(user);
		}
    }

	public void createRealTestUsersAndSaveToDb() {
		this.createRealTestUsers();
		this.saveRealTestUsersToDb();
	}
    
}
