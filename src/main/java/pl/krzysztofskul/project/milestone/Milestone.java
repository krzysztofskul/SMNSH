package pl.krzysztofskul.project.milestone;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
	
	private Date dateStartPlanned;
	
	private Date dateFinishPlanned;
	
	private Date dateStarted;
	
	private Date dateFinished;
	
	private String Description;

	/**
	 * constructors
	 */
	
	public Milestone() {
		// TODO Auto-generated constructor stub
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

	public Date getDateStartPlanned() {
		return dateStartPlanned;
	}

	public void setDateStartPlanned(Date dateStartPlanned) {
		this.dateStartPlanned = dateStartPlanned;
	}

	public Date getDateFinishPlanned() {
		return dateFinishPlanned;
	}

	public void setDateFinishPlanned(Date dateFinishPlanned) {
		this.dateFinishPlanned = dateFinishPlanned;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
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
