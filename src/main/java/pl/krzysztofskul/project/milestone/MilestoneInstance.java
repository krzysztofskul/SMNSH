package pl.krzysztofskul.project.milestone;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.validation.constraints.FutureOrPresent;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.projectCharter.ProjectCharter;

@Entity
public class MilestoneInstance extends Milestone {

	/**
	 * parameters
	 */
	
	@ManyToMany(mappedBy = "milestoneInstanceList")
	private List<ProjectCharter> projectCharterList = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private MilestoneTimeline milestoneTimeline = new MilestoneTimeline();
	
	/**
	 * constructors
	 */
	
	public MilestoneInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MilestoneInstance(MilestoneTemplate milestoneTemplate) {
		super(
				Long.parseLong("0"),
				milestoneTemplate.getCodeName(),
				milestoneTemplate.getNamePL(),
				milestoneTemplate.getNameEN(),
				milestoneTemplate.getDescription()	
		);
	}

	/**
	 * getters and setters
	 */

	public List<ProjectCharter> getProjectCharterList() {
		return projectCharterList;
	}

	public void setProjectCharterList(List<ProjectCharter> projectCharter) {
		this.projectCharterList = projectCharter;
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
