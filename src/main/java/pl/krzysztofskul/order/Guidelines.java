package pl.krzysztofskul.order;

import javax.persistence.Entity;

@Entity
public class Guidelines extends Order {

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
