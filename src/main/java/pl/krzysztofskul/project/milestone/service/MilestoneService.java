package pl.krzysztofskul.project.milestone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.krzysztofskul.project.milestone.Milestone;
import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.project.milestone.MilestoneSingleton;
import pl.krzysztofskul.project.milestone.MilestoneTemplate;
import pl.krzysztofskul.project.milestone.repo.MilestoneInstanceRepo;
import pl.krzysztofskul.project.milestone.repo.MilestoneRepo;
import pl.krzysztofskul.project.milestone.repo.MilestoneTemplateRepo;
import pl.krzysztofskul.projectCharter.ProjectCharterRepo;

@Service
@Transactional
public class MilestoneService {

	private MilestoneRepo milestoneRepo;
	private MilestoneTemplateRepo milestoneTemplateRepo;
	private MilestoneInstanceRepo milestoneInstanceRepo;
	private ProjectCharterRepo projectCharterRepo;

	

	public MilestoneService(
			MilestoneRepo milestoneRepo, 
			MilestoneTemplateRepo milestoneTemplateRepo,
			MilestoneInstanceRepo milestoneInstanceRepo,
			ProjectCharterRepo projectCharterRepo) {
		//super();
		this.milestoneRepo = milestoneRepo;
		this.milestoneTemplateRepo = milestoneTemplateRepo;
		this.milestoneInstanceRepo = milestoneInstanceRepo;
		this.projectCharterRepo = projectCharterRepo;
	}

	/**
	 * CRUD METHODS
	 */
	
	public void initMilestoneTemplatesIntiDB() {
		for (MilestoneTemplate milestoneTemplate : MilestoneSingleton.getMilestoneSingleton().getMilestoneTemplates()) {
			this.saveMilestone(milestoneTemplate);
		}
	}
	
	public void saveMilestone(Milestone milestone) {
		milestoneRepo.save(milestone);
	}
	
	public MilestoneInstance saveMilestoneInstance(MilestoneInstance milestoneInstance) {
		return milestoneRepo.save(milestoneInstance);
	}
	
	
	public List<MilestoneTemplate> loadAllMilestoneTemplateList() {
		return milestoneTemplateRepo.findAll();
	}

	public List<MilestoneInstance> loadAllMilestoneInstanceList() {
		return milestoneInstanceRepo.findAll();
	}
	
	public MilestoneTemplate loadMielestoneTemplateById(Long milestoneTemplateId) {
		return milestoneTemplateRepo.findById(milestoneTemplateId).get();
	}

	public MilestoneInstance loadMielestoneInstanceById(Long milestoneInstanceId) {
		
		MilestoneInstance milestoneInstance = milestoneInstanceRepo.findById(milestoneInstanceId).get();
		
//		TODO 2022-10-08 save edited milestone instance... create post/put method...
		return milestoneInstance;
	}
	
	public MilestoneInstance loadMielestoneInstanceByIdWithProjectCharterList(Long milestoneInstaceId) {
		MilestoneInstance milestoneInstance = loadMielestoneInstanceById(milestoneInstaceId);
		Hibernate.initialize(milestoneInstance.getProjectCharterList());
		return milestoneInstance;
	}
	
	public void deleteMilestoneInstance(Long milestoneInstanceId) {
		milestoneInstanceRepo.deleteById(milestoneInstanceId);
	}
	
	/**
	 * NO-CRUD METHODS
	 */


}
