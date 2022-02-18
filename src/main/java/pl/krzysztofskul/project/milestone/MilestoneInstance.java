package pl.krzysztofskul.project.milestone;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;

import pl.krzysztofskul.project.Project;

@Entity
public class MilestoneInstance extends Milestone {

	/**
	 * parameters
	 */
	
	/*
	 * todo 
	 */
//	@ManyToOne
//	private Project project;
	
	@OneToOne(cascade = CascadeType.ALL)
	private MilestoneTimeline milestoneTimeline = new MilestoneTimeline();
	
	/**
	 * constructors
	 */
	
	public MilestoneInstance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * getters and setters
	 */
	
	
	/*
	 * todo
	 */
//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}

	public MilestoneTimeline getMilestoneTimeline() {
		return milestoneTimeline;
	}

	public void setMilestoneTimeline(MilestoneTimeline milestoneTimeline) {
		this.milestoneTimeline = milestoneTimeline;
	}
	
	
	/**
	 * methods
	 */
	
	
}
