package pl.krzysztofskul.stakeholder;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.user.User;

@Entity
public class Stakeholder extends User {
	
	private String company;
	private String stakeholderBusinessPosition;
	
	@ManyToMany
	private List<ProjectCharter> projectCharters = new ArrayList<>();
	
	@OneToMany(mappedBy = "stakeholder")
	private List<StakeholderInProjectDetails> stakeholderInProjectDetails = new ArrayList<>();

	/*
	 * getters and setters
	 */
	
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
