package pl.krzysztofskul.order.concept;

import pl.krzysztofskul.order.Order;

import javax.persistence.Entity;

@Entity
public class Concept extends Order {

    /**
     * params.
     */

    private boolean isLayout;

    private boolean isOnSiteVisited;

    private String remarks;

    /**
     * constr.
     */

    /**
     *  getters and setters
     */

    public boolean isLayout() {
        return isLayout;
    }

    public void setLayout(boolean layout) {
        isLayout = layout;
    }

    public boolean isOnSiteVisited() {
        return isOnSiteVisited;
    }

    public void setOnSiteVisited(boolean onSiteVisited) {
        isOnSiteVisited = onSiteVisited;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
