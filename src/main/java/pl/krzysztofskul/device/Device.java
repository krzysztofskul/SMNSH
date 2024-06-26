package pl.krzysztofskul.device;

import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.device.instance.Instance;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.configuration.Configuration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Device {

    /**
     * params.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @OneToMany(mappedBy = "device", cascade = CascadeType.REMOVE)
    private List<Concept> conceptList = new ArrayList<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.REMOVE)
    private List<Guideline> guidelineList = new ArrayList<>();

    @ManyToOne
    private DeviceCategory deviceCategory;

    @ManyToMany(mappedBy = "deviceList")
    private List<Project> projectList = new ArrayList<>();

    @OneToMany(mappedBy = "device")
    private List<Configuration> configurationList = new ArrayList<>();

    @OneToMany(mappedBy = "device")
    private List<Instance> instances = new ArrayList<Instance>();
    
    /**
     * constr.
     */


    /**
     * getters and setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Concept> getConceptList() {
        return conceptList;
    }

    public void setConceptList(List<Concept> conceptList) {
        this.conceptList = conceptList;
    }

    public List<Guideline> getGuidelineList() {
        return guidelineList;
    }

    public void setGuidelineList(List<Guideline> guidelineList) {
        this.guidelineList = guidelineList;
    }

    public DeviceCategory getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Configuration> getConfigurationList() {
        return configurationList;
    }

    public void setConfigurationList(List<Configuration> configurationList) {
        this.configurationList = configurationList;
    }

    public List<Instance> getInstances() {
		return instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	/**
     * methods
     */

    public void addConfiguration(Configuration configuration) {
        this.configurationList.add(configuration);
        configuration.setDevice(this);
    }

    public void addInstance(Instance instance) {
    	this.instances.add(instance);
    	instance.setDevice(this);
    }
    
}
