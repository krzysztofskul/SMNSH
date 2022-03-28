package pl.krzysztofskul.projectCharter;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.MilestoneTemplate;
import pl.krzysztofskul.project.milestone.service.MilestoneService;
import pl.krzysztofskul.stakeholder.StakeholderInProjectDetails;
import pl.krzysztofskul.stakeholder.StakeholderService;

@Service
@Transactional
public class ProjectCharterService {

    private ProjectCharterRepo projectCharterRepo;
    private MilestoneService milestoneService;
    @Autowired
    private StakeholderService stakeholderService;

    @Autowired
    public ProjectCharterService(
    		ProjectCharterRepo projectCharterRepo, 
    		MilestoneService milestoneService
		) {
		super();
		this.projectCharterRepo = projectCharterRepo;
		this.milestoneService = milestoneService;
	}


    /*
     * crud methods
     */
    
    public List<ProjectCharter> loadAll() {
    	return projectCharterRepo.findAll();
    }

	public List<ProjectCharter> loadAllWithMilestoneInstanceList() {
    	List<ProjectCharter> projectCharterList = projectCharterRepo.findAll();     	
    	for (ProjectCharter projectCharter : projectCharterList) {
    		Hibernate.initialize(projectCharter.getMilestoneInstanceList());	
		}
    	return projectCharterList;
    }
    
    public ProjectCharter loadById(Long id) {
        return projectCharterRepo.findById(id).get();
    }
    
    public ProjectCharter loadByIdWithStakeholders(Long id) {
		ProjectCharter projectCharter = this.loadById(id);
		Hibernate.initialize(projectCharter.getStakeholders());
		return projectCharter;
	}
    
	public ProjectCharter loadByIdWithStakeholderInProjectDetailsList(Long projectCharterId) {
		ProjectCharter projectCharter = this.loadById(projectCharterId);
		Hibernate.initialize(projectCharter.getStakeholderInProjectDetailsList());
		return projectCharter;
	}
    
    public ProjectCharter loadByIdWithMilestoneInstanceList(Long id) {
    	ProjectCharter projectCharter = projectCharterRepo.findById(id).get();
    	Hibernate.initialize(projectCharter.getMilestoneInstanceList());
    	return projectCharter;
    }

    public ProjectCharter save(ProjectCharter projectCharter) {
        return projectCharterRepo.save(projectCharter);
    }
    
    public void removeMilestoneInstance(Long projectId, Long mielstoneInstanceId) {
	    	ProjectCharter projectCharter = this.loadByIdWithMilestoneInstance(projectId);
	    	MilestoneInstance milestoneInstance = milestoneService.loadMielestoneInstanceById(mielstoneInstanceId);
	    	projectCharter.removeMilestoneInstance(milestoneInstance);
	    	milestoneService.deleteMilestoneInstance(mielstoneInstanceId);
			this.save(projectCharter);
	    }
    
	private ProjectCharter loadByIdWithMilestoneInstance(Long milestoneId) {
		ProjectCharter projectCharter = this.loadById(milestoneId);
		Hibernate.initialize(projectCharter.getMilestoneInstanceList());
		return projectCharter;
	}
    
    /*
     * no-crud methods
     */
    
    public void addMilestoneInstanceFromTemplates(Long projectId, Long milestoneTemplateId) {
    	ProjectCharter projectCharter = this.loadByIdWithMilestoneInstance(projectId);
    	MilestoneTemplate milestoneTemplate = milestoneService.loadMielestoneTemplateById(milestoneTemplateId);
    	MilestoneInstance milestoneInstance = new MilestoneInstance(milestoneTemplate);
    	milestoneInstance = milestoneService.saveMilestoneInstance(milestoneInstance);
    	projectCharter.addMilestoneInstance(milestoneInstance);
    	this.save(projectCharter);
    }


	public void addMilestoneInstance(Long projectCharterId, Long milestoneInstanceId) {
    	ProjectCharter projectCharter = this.loadByIdWithMilestoneInstance(projectCharterId);
    	MilestoneInstance milestoneInstance = milestoneService.loadMielestoneInstanceById(milestoneInstanceId);
    	projectCharter.addMilestoneInstance(milestoneInstance);
    	this.save(projectCharter);
		
	}
	
	public void addStakeholderInProjectDetailsToProjectCharter(Long stakeholderInProjectDetailsId, Long projectCharterId) {
		addStakeholderInProjectDetailsToProjectCharter(stakeholderService.loadStakeholderInProjectDetailsById(projectCharterId), projectCharterId);
	}
	
	public void addStakeholderInProjectDetailsToProjectCharter(StakeholderInProjectDetails stakeholderInProjectDetails, Long projectCharterId) {
		ProjectCharter projectCharter = this.loadByIdWithStakeholderInProjectDetailsList(projectCharterId);
		projectCharter.addStakeholderInProjectDetails(stakeholderInProjectDetails);
		this.save(projectCharter);
	}

    
}
