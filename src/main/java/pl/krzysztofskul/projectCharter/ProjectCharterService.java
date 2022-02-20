package pl.krzysztofskul.projectCharter;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.MilestoneTemplate;
import pl.krzysztofskul.project.milestone.service.MilestoneService;

@Service
@Transactional
public class ProjectCharterService {

    private ProjectCharterRepo projectCharterRepo;
    private MilestoneService milestoneService;

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

    public ProjectCharter save(ProjectCharter projectCharter) {
        return projectCharterRepo.save(projectCharter);
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
    
}
