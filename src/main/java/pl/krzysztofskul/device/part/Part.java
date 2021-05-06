package pl.krzysztofskul.device.part;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.project.Project;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Part {

    /**
     * params.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

//    @ManyToOne
//    private DeviceCategory deviceCategory;

    @ManyToMany
    private List<Device> deviceList = new ArrayList<>();

    @ManyToOne
    private Project project;

    /**
     * constructors
     */

    public Part() {
    }

    public Part(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /*public DeviceCategory getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
    }*/

    public List<Device> getDevice() {
        return deviceList;
    }

    public void setDevice(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * additional methods
     */

}
