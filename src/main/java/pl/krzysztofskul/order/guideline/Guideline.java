package pl.krzysztofskul.order.guideline;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.order.Order;
import pl.krzysztofskul.order.concept.Concept;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Guideline extends Order {

    /**
     * params.
     */

    private String remarks;

    @OneToOne
    private Concept concept;

    @ManyToOne
    private Device device;

    /**
     * constr.
     */

    /**
     * getters and setters
     */

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
