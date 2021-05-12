package pl.krzysztofskul.device.part;

import pl.krzysztofskul.project.configuration.Configuration;

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

    private String description;

    @ManyToMany(mappedBy = "partList")
    private List<Configuration> configurationList = new ArrayList<>();

    /**
     * constructors
     */

    public Part() {
    }

    public Part(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
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



    public List<Configuration> getConfigurationList() {
        return configurationList;
    }

    public void setConfigurationList(List<Configuration> configurationList) {
        this.configurationList = configurationList;
    }

    /**
     * additional methods
     */

}
