package pl.krzysztofskul.project.configuration;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.part.Part;
import pl.krzysztofskul.device.prototype.Prototype;
import pl.krzysztofskul.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Configuration {

    /**
     * params.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Device device;
    
    @ManyToOne
    private Prototype prototype;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "configuration_part",
            joinColumns = {@JoinColumn(name = "configuration_id")},
            inverseJoinColumns = {@JoinColumn(name = "part_id")}
    )
    private List<Part> partList = new ArrayList<>();

    /**
     * constructors
     */

    public Configuration() {
    }

    public Configuration(Project project, Device device) {
        this.project = project;
        this.device = device;
    }
    
    public Configuration(Project project, Prototype prototype) {
        this.project = project;
        this.prototype = prototype;
    }

    public Configuration(Project project) {
        this.project = project;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }
    
    public Prototype getPrototype() {
		return prototype;
	}

	public void setPrototype(Prototype prototype) {
		this.prototype = prototype;
	}

	/**
     * methods
     * */

    public void addPart(Part part) {
        this.partList.add(part);
    }

}
