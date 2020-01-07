package pl.krzysztofskul.user;

import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.guideline.Guideline;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    /** params.
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameFirst;

    private String nameLast;

    private UserBusinessPosition businessPosition;

    @Email
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Concept> conceptList = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Guideline> guidelineList = new ArrayList<>();

    /** constr.
     *
     */

    /** getters and setters
     *
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public UserBusinessPosition getBusinessPosition() {
        return businessPosition;
    }

    public void setBusinessPosition(UserBusinessPosition businessPosition) {
        this.businessPosition = businessPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Concept> getConceptList() {
        return conceptList;
    }

    public void setConceptList(List<Concept> conceptList) {
        this.conceptList = conceptList;
    }

    public List<Guideline> getGuidelineList() {
        return guidelineList;
    }

    public void setGuidelineList(List<Guideline> guidelineList) {
        this.guidelineList = guidelineList;
    }
}
