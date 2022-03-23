package pl.krzysztofskul.stakeholder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.projectCharter.ProjectCharter;

@Entity
public class StakeholderInProjectDetails {
	
	@Id
	private Long id;
	
	@ManyToOne
	private Stakeholder stakeholder;
	
	@ManyToOne
	private ProjectCharter projectCharter;
	
	private String roleInProject;
	private String description;
	
	/*
	 * getters and setters
	 */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Stakeholder getStakeholder() {
		return stakeholder;
	}
	public void setStakeholder(Stakeholder stakeholder) {
		this.stakeholder = stakeholder;
	}
	public ProjectCharter getProjectCharter() {
		return projectCharter;
	}
	public void setProjectCharter(ProjectCharter projectCharter) {
		this.projectCharter = projectCharter;
	}
	public String getRoleInProject() {
		return roleInProject;
	}
	public void setRoleInProject(String roleInProject) {
		this.roleInProject = roleInProject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
