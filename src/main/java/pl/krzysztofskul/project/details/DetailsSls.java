package pl.krzysztofskul.project.details;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.project.Project;

@Entity
public class DetailsSls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "detailsSls")
	private Project project;
	
	private String slsCodeShort;
	private String slsCodeFull;
	
	private String importedDeviceModality;
	private String importedDeviceModelName;
	
	private String importedProjectManager;
	
	private String importedCustomer;

	public DetailsSls() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSlsCodeShort() {
		return slsCodeShort;
	}

	public void setSlsCodeShort(String slsCodeShort) {
		this.slsCodeShort = slsCodeShort;
	}

	public String getSlsCodeFull() {
		return slsCodeFull;
	}

	public void setSlsCodeFull(String slsCodeFull) {
		this.slsCodeFull = slsCodeFull;
	}

	public String getImportedDeviceModality() {
		return importedDeviceModality;
	}

	public void setImportedDeviceModality(String importedDeviceModality) {
		this.importedDeviceModality = importedDeviceModality;
	}

	public String getImportedDeviceModelName() {
		return importedDeviceModelName;
	}

	public void setImportedDeviceModelName(String importedDeviceModelName) {
		this.importedDeviceModelName = importedDeviceModelName;
	}

	public String getImportedProjectManager() {
		return importedProjectManager;
	}

	public void setImportedProjectManager(String importedProjectManager) {
		this.importedProjectManager = importedProjectManager;
	}

	public String getImportedCustomer() {
		return importedCustomer;
	}

	public void setImportedCustomer(String importedCustomer) {
		this.importedCustomer = importedCustomer;
	}


	
	
	
}
