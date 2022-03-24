package pl.krzysztofskul.stakeholder;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.user.User;

@Entity
public class Stakeholder {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nameFirst;
    private String nameLast;
	
	private String company;
	private String stakeholderBusinessPosition;
	
	@ManyToMany(mappedBy = "stakeholders")
	private List<ProjectCharter> projectCharters = new ArrayList<>();
	
	@OneToMany(mappedBy = "stakeholder")
	private List<StakeholderInProjectDetails> stakeholderInProjectDetails = new ArrayList<>();

	/*
	 * getters and setters
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStakeholderBusinessPosition() {
		return stakeholderBusinessPosition;
	}

	public void setStakeholderBusinessPosition(String stakeholderBusinessPosition) {
		this.stakeholderBusinessPosition = stakeholderBusinessPosition;
	}

	public List<ProjectCharter> getProjectCharters() {
		return projectCharters;
	}

	public void setProjectCharters(List<ProjectCharter> projectCharters) {
		this.projectCharters = projectCharters;
	}

	public List<StakeholderInProjectDetails> getStakeholderInProjectDetails() {
		return stakeholderInProjectDetails;
	}

	public void setStakeholderInProjectDetails(List<StakeholderInProjectDetails> stakeholderInProjectDetails) {
		this.stakeholderInProjectDetails = stakeholderInProjectDetails;
	}

	
}
