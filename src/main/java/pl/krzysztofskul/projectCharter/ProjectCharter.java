package pl.krzysztofskul.projectCharter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.milestone.Milestone;
import pl.krzysztofskul.project.milestone.MilestoneInstance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProjectCharter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JsonIgnore
    private Project project;

    private String reasons  = LoremIpsum.getInstance().getWords(5);

    private String goals = LoremIpsum.getInstance().getWords(5);

    private String risks  = LoremIpsum.getInstance().getWords(5);

    @ManyToMany
	@JoinTable(
				name = "projectCharters_milestoneInstances",
				joinColumns = @JoinColumn(name = "projectCharter_id"),
				inverseJoinColumns = @JoinColumn(name = "milestoneInstance_ID")
				
			)
    @JsonIgnore
    private List<MilestoneInstance> milestoneInstanceList = new ArrayList<>();
    
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

    public List<MilestoneInstance> getMilestoneInstanceList() {
		return milestoneInstanceList;
	}

	public void setMilestoneInstanceList(List<MilestoneInstance> milestoneInstanceList) {
		this.milestoneInstanceList = milestoneInstanceList;
	}

	/**
     * METHODS
     */
    
	public void addMilestoneInstance(MilestoneInstance milestoneInstance) {
		this.milestoneInstanceList.add(milestoneInstance);
		//milestoneInstance.addProjectCharter(this);
	}
	
	public void removeMilestoneInstance(Milestone milestone) {
		// todo
	}
	
}
