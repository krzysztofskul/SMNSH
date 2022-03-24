package pl.krzysztofskul.stakeholder;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.krzysztofskul.user.User;

@Service
public class StakeholderService {

	/**
	 * param.
	 */
	
	private StakeholderRepo stakeholderRepo;
	private StakeholderInPtojectDetailsRepo stakeholderInProjectDetailsRepo;
	
	
	/**
	 * constr.
	 * @param stakeholderRepo
	 */
	public StakeholderService(
			StakeholderRepo stakeholderRepo,
			StakeholderInPtojectDetailsRepo stakeholderInProjectDetailsrepo
	) {
		super();
		this.stakeholderRepo = stakeholderRepo;
		this.stakeholderInProjectDetailsRepo = stakeholderInProjectDetailsRepo;
	}
	
	/**
	 * CRUD methods for Stakeholder class
	 */
	
	public Stakeholder loadStakeholderById(Long id) {
		return stakeholderRepo.findById(id).get();
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
	
	public void createInitTestStakeholders() {
		// todo
	}
	
	
	
}
