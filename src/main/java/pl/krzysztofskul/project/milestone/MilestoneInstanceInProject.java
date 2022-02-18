package pl.krzysztofskul.project.milestone;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.krzysztofskul.project.Project;

@Entity
public class MilestoneInstanceInProject {
	
	/**
	 * parameters
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne // todo 2022-02-18
	private Milestone milestone;
	
	@ManyToOne // todo 2022-02-18
	private Project project;
	
	@OneToOne
	private MilestoneTimeline milestoneTimeline = new MilestoneTimeline();
	
	/**
	 * constructors
	 */
	
	public MilestoneInstanceInProject() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * getters and setters
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
