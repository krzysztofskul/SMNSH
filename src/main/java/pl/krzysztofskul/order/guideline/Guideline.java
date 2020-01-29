package pl.krzysztofskul.order.guideline;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.order.Order;
import pl.krzysztofskul.order.Status;
import pl.krzysztofskul.order.concept.Concept;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
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

    /**
     * constr.
     */

    public Guideline() {
        this.setTitle("Zamówienie projektu WYTYCZNYCH na sprzęt: ..., dla klienta: ... / New order for GUIDELINES PROJECT for device: ..., to the customer: ...");
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

    /**
     * methods
     */

    @PrePersist
    public void prePersist() {
        this.setDateTimeCreated(LocalDateTime.now());
        setStatus(Status.ORDERED_WAITING);
    }
}
