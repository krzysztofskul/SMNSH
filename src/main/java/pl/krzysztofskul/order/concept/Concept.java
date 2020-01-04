package pl.krzysztofskul.order.concept;

import pl.krzysztofskul.order.Order;
import pl.krzysztofskul.order.guideline.Guideline;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Concept extends Order {

    /**
     * params.
     */

    private boolean isLayout;

    private boolean isOnSiteVisited;

    private String remarks;

    @OneToOne(mappedBy = "concept")
    private Guideline guideline;

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

    public Guideline getGuideline() {
        return guideline;
    }

    public void setGuideline(Guideline guideline) {
        this.guideline = guideline;
    }
}
