package pl.krzysztofskul.order.concept;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.prototype.Prototype;
import pl.krzysztofskul.order.Order;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.questionnaire.QuestionForm;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.validator.StatusPlannerMatch;

import javax.persistence.*;
import java.time.LocalDateTime;

@StatusPlannerMatch.List({
        @StatusPlannerMatch(
                status = "status",
                planner = "planner"
        )
})
@Entity
public class Concept extends Order {

    /**
     * params.
     */

    private boolean isLayout;

    private boolean isOnSiteVisited;

    private boolean isWallInterferencePossible;

    private String customerSuggestions;

    private boolean isTransportRouteDesignNeeded;

    private boolean isElectricBoxSpecified;

    private String additionalRoomsToDesign;

    private String remarks;

    @OneToOne(mappedBy = "concept", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Guideline guideline;

    @ManyToOne
    private Device device;
    
    @ManyToOne
    private Prototype prototype;

    @ManyToOne
    private User planner;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private QuestionForm questionForm;

    @ManyToOne
    private Project project;

    /**
     * constr.
     */
    public Concept() {
        this.setTitle("Zamówienie koncpecji. / Order for preliminary design.");
    }

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

    public boolean isWallInterferencePossible() {
        return isWallInterferencePossible;
    }

    public void setWallInterferencePossible(boolean wallInterferencePossible) {
        isWallInterferencePossible = wallInterferencePossible;
    }

    public String getCustomerSuggestions() {
        return customerSuggestions;
    }

    public void setCustomerSuggestions(String customerSuggestions) {
        this.customerSuggestions = customerSuggestions;
    }

    public boolean isTransportRouteDesignNeeded() {
        return isTransportRouteDesignNeeded;
    }

    public void setTransportRouteDesignNeeded(boolean transportRouteDesignNeeded) {
        isTransportRouteDesignNeeded = transportRouteDesignNeeded;
    }

    public boolean isElectricBoxSpecified() {
        return isElectricBoxSpecified;
    }

    public void setElectricBoxSpecified(boolean electricBoxSpecified) {
        isElectricBoxSpecified = electricBoxSpecified;
    }

    public String getAdditionalRoomsToDesign() {
        return additionalRoomsToDesign;
    }

    public void setAdditionalRoomsToDesign(String additionalRoomsToDesign) {
        this.additionalRoomsToDesign = additionalRoomsToDesign;
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
    
    public Prototype getPrototype() {
		return prototype;
	}

	public void setPrototype(Prototype prototype) {
		this.prototype = prototype;
	}

	public User getPlanner() {
        return planner;
    }

    public void setPlanner(User planner) {
        this.planner = planner;
    }

    public QuestionForm getQuestionForm() {
        return questionForm;
    }

    public void setQuestionForm(QuestionForm questionForm) {
        this.questionForm = questionForm;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * methods
     */

    @PrePersist
    public void prePersist() {
        this.setDateTimeCreated(LocalDateTime.now());
        setStatus(Status.ORDERED_WAITING);
    }

}
