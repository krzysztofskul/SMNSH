package pl.krzysztofskul.initDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.projectCharter.ProjectCharterService;
import pl.krzysztofskul.stakeholder.Stakeholder;
import pl.krzysztofskul.stakeholder.StakeholderService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;

@Service
@Transactional
public class InitDbForTests {

	@Autowired
	ProjectCharterService projectCharterService;
	@Autowired
	UserService userService;
	@Autowired
	StakeholderService stakeholderService;
	
	public static List<User> userTestList = new ArrayList<>();
	public static User userTestSls = new User();
	public static User userTestPlanner = new User();
	public static Project projectTest;
	public static Stakeholder stakeholderFromUserTest1;
	public static Stakeholder stakeholderFromUserTest2;
	public static List<Stakeholder> stakeholderFromUserTestList = new ArrayList<Stakeholder>();
	
	public void createTestUsersAndStakeholders() {
		userTestSls.setNameFirst(LoremIpsum.getInstance().getFirstName());
		userTestSls.setNameLast(LoremIpsum.getInstance().getLastName());
		userTestSls.setBusinessPosition(UserBusinessPosition.SALES_REP);
		userTestSls = userService.saveAndReturn(userTestSls);
		userTestPlanner.setNameFirst(LoremIpsum.getInstance().getFirstName());
		userTestPlanner.setNameLast(LoremIpsum.getInstance().getLastName());
		userTestPlanner.setBusinessPosition(UserBusinessPosition.PLANNER);
		userTestPlanner = userService.saveAndReturn(userTestPlanner);
		userTestList.add(userTestSls);
		userTestList.add(userTestPlanner);
		stakeholderFromUserTest1 = stakeholderService.createAndGetInitTestStakeholderFromUser(userTestSls);
		stakeholderFromUserTest2 = stakeholderService.createAndGetInitTestStakeholderFromUser(userTestPlanner);
		stakeholderFromUserTestList.add(stakeholderFromUserTest1);
		stakeholderFromUserTestList.add(stakeholderFromUserTest2);
	}
	
	public List<Stakeholder> getTestStakeholders() {
		for (Stakeholder stakeholder : stakeholderFromUserTestList) {
			stakeholder = stakeholderService.saveStakeholder(stakeholder);
		}
		return stakeholderFromUserTestList;
	}

	public ProjectCharter getRandomProjectCharterWithStakeholderInProjectDetailsList() {
		List<ProjectCharter> projectCharterList = projectCharterService.loadAll();
		ProjectCharter projectCharter = projectCharterService.loadByIdWithStakeholderInProjectDetailsList((long) new Random().nextInt(projectCharterList.size()+1));
		return projectCharter;
	}
	
	public Stakeholder createAndReturnNewTestStakeholder() {
		return new Stakeholder(LoremIpsum.getInstance().getFirstName(), LoremIpsum.getInstance().getLastName(), LoremIpsum.getInstance().getName()+" Inc.", "test employee");
	}
	
}
