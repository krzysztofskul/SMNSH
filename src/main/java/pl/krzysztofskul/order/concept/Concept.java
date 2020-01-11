package pl.krzysztofskul.order.concept;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.order.Order;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.user.User;

import javax.persistence.*;

@Entity
public class Concept extends Order {

    /**
     * params.
     */

    private Status status;

    private boolean isLayout;

    private boolean isOnSiteVisited;

    private String remarks;

    @OneToOne(mappedBy = "concept", cascade = CascadeType.REMOVE)
    private Guideline guideline;

    @ManyToOne
    private Device device;

    @ManyToOne
    private User planner;

    /**
     * constr.
     */

    /**
     *  getters and setters
     */

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User getPlanner() {
        return planner;
    }

    public void setPlanner(User planner) {
        this.planner = planner;
    }

    /**
     * methods
     */

    @PrePersist
    public void prePersist() {
        setStatus(Status.ORDERED_WAITING);
    }

}
