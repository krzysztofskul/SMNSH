package pl.krzysztofskul.project.milestone;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MilestoneTimeline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date dateStartPlanned;
	private Date dateFinishPlanned;
	private Date dateStarted;
	private Date dateFinished;
	
	@OneToOne(mappedBy = "milestoneTimeline")
	private MilestoneInstance milestoneInstance;

	public MilestoneTimeline() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDateStartPlanned() {
		return dateStartPlanned;
	}

	public void setDateStartPlanned(Date dateStartPlanned) {
		this.dateStartPlanned = dateStartPlanned;
	}

	public Date getDateFinishPlanned() {
		return dateFinishPlanned;
	}

	public void setDateFinishPlanned(Date dateFinishPlanned) {
		this.dateFinishPlanned = dateFinishPlanned;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public MilestoneInstance getMilestoneInstance() {
		return milestoneInstance;
	}

	public void setMilestoneInstance(MilestoneInstance milestoneInstance) {
		this.milestoneInstance = milestoneInstance;
	}
	
	
	
}