package pl.krzysztofskul.project.milestone;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private LocalDateTime dateFinishPlanned;
	private LocalDate dateStarted;
	private LocalDate dateFinished;
	
	@OneToOne(mappedBy = "milestoneTimeline")
	private MilestoneInstance milestoneInstance;

	public MilestoneTimeline() {
		/**
		 * TODO 2022-09-22
		 * milestones functionality updates
		 * - demo updates with demo dates
		 * - new milestone with set dates by user
		 * - set as finished functionality
		 * - sort by option?
		 */
	}
	
	public MilestoneTimeline(String demoType) {
		if (demoType.equals("demo-init")) {
			int x = LocalTime.now().getSecond() + LocalTime.now().getNano()/1000000;
			this.setDateFinishPlanned(LocalDateTime.now().plusDays(x));	
		}

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

	public LocalDateTime getDateFinishPlanned() {
		return dateFinishPlanned;
	}

	public void setDateFinishPlanned(LocalDateTime dateFinishPlanned) {
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