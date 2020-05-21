package pl.krzysztofskul.order.guideline;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.order.Order;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Guideline extends Order {

    /**
     * params.
     */

    private String remarks;

    @NotBlank(message = "Wpisz osobę akceptującą projekt koncepcyjny ze strony klienta / Enter person who accepted conceptual project from customer site!")
    private String personAccepting;

    @PastOrPresent
    private LocalDate dateOfAcceptation;

    @OneToOne
    private Concept concept;

    @ManyToOne
    private Device device;

    @ManyToOne
    private User designer;

    /**
     * constr.
     */

    public Guideline() {
        this.setTitle("Zamówienie wytycznych. / Order for final planning.");
        this.setDateOfAcceptation(LocalDate.now());
    }

    /**
     * getters and setters
     */

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPersonAccepting() {
        return personAccepting;
    }

    public void setPersonAccepting(String personAccepting) {
        this.personAccepting = personAccepting;
    }

    public LocalDate getDateOfAcceptation() {
        return dateOfAcceptation;
    }

    public void setDateOfAcceptation(LocalDate dateOfAcceptation) {
        this.dateOfAcceptation = dateOfAcceptation;
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

    public User getDesigner() {
        return designer;
    }

    public void setDesigner(User designer) {
        this.designer = designer;
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
