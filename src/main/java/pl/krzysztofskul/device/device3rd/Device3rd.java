package pl.krzysztofskul.device.device3rd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import pl.krzysztofskul.project.Project;

@Entity
public class Device3rd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String manufacturerName;
	
	private String modelName;
	
	private String description;
	
	@ManyToOne
	private Project project;

	/**
	 * Constructor
	 */
	public Device3rd() {
		super();
	}

	/**
	 * Constructor
	 * @param manufacturerName
	 * @param modelName
	 * @param description
	 */
	public Device3rd(String manufacturerName, String modelName, String description) {
		super();
		this.manufacturerName = manufacturerName;
		this.modelName = modelName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
