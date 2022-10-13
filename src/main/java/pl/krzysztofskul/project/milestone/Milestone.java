package pl.krzysztofskul.project.milestone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import pl.krzysztofskul.projectCharter.ProjectCharter;

/**
 * 
 * @author krzysztofskul
 * This class represents milestones' templates possible to use inside the project, which are saved into database and are not mutable. 
 *
 */

@MappedSuperclass
public class Milestone {
	
	/**
	 * parameters
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codeName;
	
	private String namePL;
	
	private String nameEN;
	
	private String Description;
	
	/**
	 * constructors
	 */
	
	public Milestone() {
	}
	
	public Milestone(Long id, String codeName, String namePL, String nameEN, String description) {
		//super();
		this.id = id;
		this.codeName = codeName;
		this.namePL = namePL;
		this.nameEN = nameEN;
		Description = description;
	}



	/**
	 * getters and setters
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getNamePL() {
		return namePL;
	}

	public void setNamePL(String namePL) {
		this.namePL = namePL;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	/**
	 * methods
	 */
	
}