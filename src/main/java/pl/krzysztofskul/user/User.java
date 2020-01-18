package pl.krzysztofskul.user;

import org.mindrot.jbcrypt.BCrypt;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.user.avatar.Avatar;
import pl.krzysztofskul.validator.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @Column(unique = true)
    @UniqueEmail
    private String email;

    @NotBlank(message = "Hasło nie może być puste / The password cannot be empty!")
    private String password;

    private String passwordConfirmation;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Concept> conceptList = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Guideline> guidelineList = new ArrayList<>();

    @OneToMany(mappedBy = "planner", cascade = CascadeType.ALL)
    private List<Concept> conceptListToDo = new ArrayList<>();

    @OneToOne
    private Avatar avatar;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
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

    public List<Concept> getConceptListToDo() {
        return conceptListToDo;
    }

    public void setConceptListToDo(List<Concept> conceptListToDo) {
        this.conceptListToDo = conceptListToDo;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * methods
     */
    public void addConceptToDo(Concept concept) {
        this.conceptListToDo.add(concept);
    }
    public void removeConceptToDo(Concept concept) {
        this.conceptListToDo.remove(concept);
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.getPassword());
    }

}