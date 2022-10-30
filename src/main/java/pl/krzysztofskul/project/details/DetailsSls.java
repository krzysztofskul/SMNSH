package pl.krzysztofskul.project.details;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.project.Project;

@Entity
public class DetailsSls {

	@OneToOne(mappedBy = "detailsSls")
	private Project project;
	
	private String slsCodeShort;
	private String slsCodeFull;
	
	private String importedDeviceModality;
	private String importedDeviceModelName;
	
	private String importedProjectManager;
	
	private String importedCostumer;

	private DetailsSls() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getImportedCostumer() {
		return importedCostumer;
	}

	public void setImportedCostumer(String importedCostumer) {
		this.importedCostumer = importedCostumer;
	}
	
	
	
}
