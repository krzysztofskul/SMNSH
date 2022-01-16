package pl.krzysztofskul.projectCharter;

import pl.krzysztofskul.project.Project;

import javax.persistence.*;

@Entity
public class ProjectCharter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private Project project;

    private String reasons;

    private String goals;

    private String risks;

    /**
     * CONSTRUCTORS
     * */

    public ProjectCharter() {
    }

    public ProjectCharter(Project project) {
        this.project = project;
    }

    /**
     * GETTERS AND SETTERS
     * */

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

}
