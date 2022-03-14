package pl.krzysztofskul.project.milestone;

import java.time.LocalDate;
import java.time.LocalTime;

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
	
	private LocalDate dateStartPlanned;
	private LocalDate dateFinishPlanned;
	private LocalDate dateStarted;
	private LocalDate dateFinished;
	
	@OneToOne(mappedBy = "milestoneTimeline")
	private MilestoneInstance milestoneInstance;

	public MilestoneTimeline() {
		int x = LocalTime.now().getSecond() + LocalTime.now().getNano()/1000000;
		this.setDateFinishPlanned(LocalDate.now().plusDays(x));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateStartPlanned() {
		return dateStartPlanned;
	}

	public void setDateStartPlanned(LocalDate dateStartPlanned) {
		this.dateStartPlanned = dateStartPlanned;
	}

	public LocalDate getDateFinishPlanned() {
		return dateFinishPlanned;
	}

	public void setDateFinishPlanned(LocalDate dateFinishPlanned) {
		this.dateFinishPlanned = dateFinishPlanned;
	}

	public LocalDate getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}

	public LocalDate getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(LocalDate dateFinished) {
		this.dateFinished = dateFinished;
	}

	public MilestoneInstance getMilestoneInstance() {
		return milestoneInstance;
	}

	public void setMilestoneInstance(MilestoneInstance milestoneInstance) {
		this.milestoneInstance = milestoneInstance;
	}

}