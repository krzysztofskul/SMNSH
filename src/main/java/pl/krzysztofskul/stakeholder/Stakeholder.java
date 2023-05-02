package pl.krzysztofskul.stakeholder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.user.User;

@Entity
public class Stakeholder {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    private String nameFirst;
    private String nameLast;
	
	private String company;
	private String stakeholderBusinessPosition;
	private String stakeholderBusinessPositionPL;
	private String stakeholderBusinessPositionEN;
	
	@ManyToMany(mappedBy = "stakeholders")
	private List<ProjectCharter> projectCharters = new ArrayList<>();
	
	@OneToMany(mappedBy = "stakeholder")
	private List<StakeholderInProjectDetails> stakeholderInProjectDetailsList = new ArrayList<>();

	private String email;

	/*
	 * constructors
	 */
	
	public Stakeholder() {
		super();
		
	}
	
	public Stakeholder(User user) {
		super();
		this.user = user;
	}
	
	public Stakeholder(String nameFirst, String nameLast, String company, String stakeholderBusinessPosition) {
		super();
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.company = company;
		this.stakeholderBusinessPosition = stakeholderBusinessPosition;
	}
	
	public Stakeholder(String nameFirst, String nameLast, String company, String stakeholderBusinessPosition, String email) {
		super();
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.company = company;
		this.stakeholderBusinessPosition = stakeholderBusinessPosition;
		this.email = email;
	}
	
	public Stakeholder(User user, String nameFirst, String nameLast, String company, String stakeholderBusinessPosition) {
		super();
		this.user = user;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.company = company;
		this.stakeholderBusinessPosition = stakeholderBusinessPosition;
	}



	/*
	 * getters and setters
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getStakeholderBusinessPositionPL() {
		return stakeholderBusinessPositionPL;
	}

	public void setStakeholderBusinessPositionPL(String stakeholderBusinessPositionPL) {
		this.stakeholderBusinessPositionPL = stakeholderBusinessPositionPL;
	}

	public String getStakeholderBusinessPositionEN() {
		return stakeholderBusinessPositionEN;
	}

	public void setStakeholderBusinessPositionEN(String stakeholderBusinessPositionEN) {
		this.stakeholderBusinessPositionEN = stakeholderBusinessPositionEN;
	}

	public List<ProjectCharter> getProjectCharters() {
		return projectCharters;
	}

	public void setProjectCharters(List<ProjectCharter> projectCharters) {
		this.projectCharters = projectCharters;
	}

	public List<StakeholderInProjectDetails> getStakeholderInProjectDetailsList() {
		return stakeholderInProjectDetailsList;
	}

	public void setStakeholderInProjectDetailsList(List<StakeholderInProjectDetails> stakeholderInProjectDetailsList) {
		this.stakeholderInProjectDetailsList = stakeholderInProjectDetailsList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//TODO: add methods addProjectCharter and removeProjectCahrer
	public void addProjectCharter(ProjectCharter projectCharter) {
		this.projectCharters.add(projectCharter);
		projectCharter.addStakeholder(this);
	}
	
}
