package pl.krzysztofskul.logger.loggerProject;


import pl.krzysztofskul.project.Project;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoggerProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Project project;

    private LocalDateTime localDateTime;

    private String actionEN;
    private String actionPL;

    private String actionBy;

    public LoggerProject() {
    }

    public LoggerProject(LocalDateTime localDateTime, String actionEN, String actionPL, String actionBy) {
		super();
		this.localDateTime = localDateTime;
		this.actionEN = actionEN;
		this.actionPL = actionPL;
		this.actionBy = actionBy;
	}

	public LoggerProject(Project project, LocalDateTime localDateTime, String actionEN, String actionPL,
			String actionBy) {
		super();
		this.project = project;
		this.localDateTime = localDateTime;
		this.actionEN = actionEN;
		this.actionPL = actionPL;
		this.actionBy = actionBy;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getActionEN() {
        return actionEN;
    }

    public void setActionEN(String actionEN) {
        this.actionEN = actionEN;
    }

    public String getActionPL() {
		return actionPL;
	}

	public void setActionPL(String actionPL) {
		this.actionPL = actionPL;
	}

	public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }
}
