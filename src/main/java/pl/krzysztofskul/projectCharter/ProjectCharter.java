package pl.krzysztofskul.projectCharter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thedeanda.lorem.LoremIpsum;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.milestone.Milestone;
import pl.krzysztofskul.project.milestone.MilestoneInstance;
import pl.krzysztofskul.stakeholder.Stakeholder;
import pl.krzysztofskul.stakeholder.StakeholderInProjectDetails;
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
    @JsonIgnore
    private List<MilestoneInstance> milestoneInstanceList = new ArrayList<>();
    
    
    @ManyToMany
    @JoinTable(
    			name = "projectcharter_stakeholder",
    			joinColumns = @JoinColumn(name = "projectCharter_id"),
    			inverseJoinColumns = @JoinColumn(name = "stakeholder_id")
    		)
    @JsonIgnore
    private List<Stakeholder> stakeholders = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "projectCharter", cascade = CascadeType.MERGE)
    private List<StakeholderInProjectDetails> stakeholderInProjectDetailsList = new ArrayList<>();
    
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
	

	public List<Stakeholder> getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(List<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
	}

	public List<StakeholderInProjectDetails> getStakeholderInProjectDetailsList() {
		return stakeholderInProjectDetailsList;
	}

	public void setStakeholderInProjectDetailsList(List<StakeholderInProjectDetails> stakeholderInProjectDetailsList) {
		this.stakeholderInProjectDetailsList = stakeholderInProjectDetailsList;
	}

	/**
     * METHODS
     */
    
	public void addMilestoneInstance(MilestoneInstance milestoneInstance) {
		this.milestoneInstanceList.add(milestoneInstance);
		//milestoneInstance.addProjectCharter(this);
	}
	
	public void removeMilestoneInstance(Milestone milestoneInstance) {
		this.milestoneInstanceList.remove(milestoneInstance);
	}

	public void addStakeholder(Stakeholder stakeholder) {
		this.stakeholders.add(stakeholder);
		//stakeholder.addProjectCharter(this);
		
	}
	
	public void removeStakeholder(Stakeholder stakeholder) {
		// TODO
	}
	
	public void addStakeholderInProjectDetails (StakeholderInProjectDetails stakeholderInProjectDetails) {
		this.stakeholderInProjectDetailsList.add(stakeholderInProjectDetails);
		stakeholderInProjectDetails.setProjectCharter(this);
	}
}
