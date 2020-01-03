package pl.krzysztofskul.order.guideline;

import pl.krzysztofskul.order.Order;

import javax.persistence.Entity;

@Entity
public class Guideline extends Order {

    /**
     * params.
     */

    private String remarks;

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
}
