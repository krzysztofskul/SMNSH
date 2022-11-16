package pl.krzysztofskul.device.prototype;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import pl.krzysztofskul.device.modality.Modality;
import pl.krzysztofskul.project.Project;

@Entity
public class Prototype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//private Modality modality;
	private String modality;
	
	private String manufacturer;
	
	private String modelName;
	
	private Long cpqNo;

    @ManyToMany(mappedBy = "prototypeList")
	private List<Project> projectList = new ArrayList<>();
	
	private Prototype() {
		super();
	}
	
	public Prototype(String manufacturer, String modelName) {
		super();
		this.manufacturer = manufacturer;
		this.modelName = modelName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Modality getModality() {
//		return modality;
//	}
//
//	public void setModality(Modality modality) {
//		this.modality = modality;
//	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Long getCpqNo() {
		return cpqNo;
	}

	public void setCpqNo(Long cpqNo) {
		this.cpqNo = cpqNo;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	
	
	
}
