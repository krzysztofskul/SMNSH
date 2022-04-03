package pl.krzysztofskul.stakeholder;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.projectCharter.ProjectCharterService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

@Service
@Transactional
public class StakeholderService {

	/**
	 * param.
	 */
	
	private StakeholderRepo stakeholderRepo;
	private StakeholderInPtojectDetailsRepo stakeholderInProjectDetailsRepo;
	private ProjectCharterService projectCharterService;
	private UserService userService;
	
	
	/**
	 * constr.
	 * @param stakeholderRepo
	 */
	@Autowired
	public StakeholderService(
			StakeholderRepo stakeholderRepo,
			StakeholderInPtojectDetailsRepo stakeholderInProjectDetailsRepo,
			UserService userService,
			ProjectCharterService projectCharterService
	) {
		super();
		this.stakeholderRepo = stakeholderRepo;
		this.stakeholderInProjectDetailsRepo = stakeholderInProjectDetailsRepo;
		this.userService = userService;
		this.projectCharterService = projectCharterService;
	}
	
	/**
	 * CRUD methods for Stakeholder class
	 */
	
	public Stakeholder loadStakeholderById(Long id) {
		return stakeholderRepo.findById(id).get();
	}
	
	private Stakeholder loadStakeholderByIdWithProjectCharters(Long stakeholderId) {
		Stakeholder stakeholder = stakeholderRepo.findById(stakeholderId).get();
		Hibernate.initialize(stakeholder.getProjectCharters());
		return stakeholder;
	}

	public List<Stakeholder> loadAllStakeholders() {
		return stakeholderRepo.findAll();
	}
	
	public Stakeholder saveStakeholder(Stakeholder stakeholder) {
		return stakeholderRepo.save(stakeholder);
	}
	
	public void deleteStakeholderById(Long id) {
		stakeholderRepo.deleteById(id);
	}
	
	/**
	 * CRUD methods for StakeholderInProjectDetails class
	 */
	
	public StakeholderInProjectDetails loadStakeholderInProjectDetailsById(Long id) {
		return stakeholderInProjectDetailsRepo.findById(id).get();
	}

	public List<StakeholderInProjectDetails> loadAllStakeholderInProjectDetails() {
		return stakeholderInProjectDetailsRepo.findAll();
	}
	
	public StakeholderInProjectDetails saveStakeholderInProjectDetails(StakeholderInProjectDetails stakeholderInProjectDetails) {
		return stakeholderInProjectDetailsRepo.save(stakeholderInProjectDetails);
	}
	
	public void deleteStakeholderInProjectDetailsById(Long id) {
		stakeholderInProjectDetailsRepo.deleteById(id);
	}
	
	/**
	 * no-CRUD methods
	 */
	
	public Stakeholder createAndGetInitTestStakeholderFromUser(User user) {
		Stakeholder stakeholder = new Stakeholder();
		stakeholder.setNameFirst(user.getNameFirst());
		stakeholder.setNameLast(user.getNameLast());
		stakeholder.setStakeholderBusinessPosition(user.getBusinessPosition().toString());
		return stakeholder;
	}
	
	public void addStakeholderFromUserToProject (Long stakeholderId, Long projectCharterId) {
		ProjectCharter projectCharter = projectCharterService.loadByIdWithStakeholders(projectCharterId);
		Stakeholder stakeholder = this.loadStakeholderByIdWithProjectCharters(stakeholderId);	
		StakeholderInProjectDetails stakeholderInProjectDetails = new StakeholderInProjectDetails();
		stakeholderInProjectDetails.setStakeholder(stakeholder);
		stakeholderInProjectDetails.setProjectCharter(projectCharter);	
		projectCharter.addStakeholder(stakeholder);	
		this.saveStakeholderInProjectDetails(stakeholderInProjectDetails);
	}


	public Stakeholder createAndAddNewStakeholderToProject(
			Long projectId, 
			String nameFirst, 
			String nameLast, 
			String company, 
			String stakeholderBusinessPosition, 
			String roleInProject,
			String description
	) {
		// todo
		return new Stakeholder();
	}

	/*
	 * method creates demo outer company stakholder (not connected with existing user) and save to db
	 */
	public void createDemoOuterCompanyStakeholderAndSaveToDb() {
		this.saveStakeholder(
				new Stakeholder(
							LoremIpsum.getInstance().getFirstName(),
							LoremIpsum.getInstance().getLastName(),
							LoremIpsum.getInstance().getName() + " Inc.",
							"Unknown business position"
						)
				);
	}
	
}
