package pl.krzysztofskul.device;

import pl.krzysztofskul.order.concept.Concept;

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

    /**
     * methods
     */

}
