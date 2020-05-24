package pl.krzysztofskul.user;

import org.mindrot.jbcrypt.BCrypt;
import pl.krzysztofskul.logger.loggerUser.LoggerUser;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.order.guideline.Guideline;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.user.avatar.Avatar;
import pl.krzysztofskul.validator.PasswordMatch;
import pl.krzysztofskul.validator.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@PasswordMatch.List({
        @PasswordMatch(
                password = "password",
                passwordConfirmation = "passwordConfirmation"
        )
})
@Entity
public class User {

    /** params.
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 32)
    private String nameFirst;

    @Size(min = 2, max = 32)
    private String nameLast;

    private UserBusinessPosition businessPosition;

    @Email
    @Column(unique = true)
    @UniqueEmail
    @NotBlank(message = "E-mail nie może być pusty / The email cannot be blank!")
    private String email;

    private String password;

    private String passwordConfirmation;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Concept> conceptList = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Guideline> guidelineList = new ArrayList<>();

    @OneToMany(mappedBy = "planner", cascade = CascadeType.ALL)
    private List<Concept> conceptListToDo = new ArrayList<>();

    @OneToMany(mappedBy = "designer", cascade = CascadeType.ALL)
    private List<Guideline> guidelineListToDo = new ArrayList<>();

    @OneToMany(mappedBy = "projectManager", cascade = CascadeType.ALL)
    private List<Project> projectList = new ArrayList<>();

    @OneToOne
    private Avatar avatar;

    @OneToMany(mappedBy = "user")
    private List<LoggerUser> loggerUserList = new ArrayList<>();

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
        this.password = password;
//        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
//        this.passwordConfirmation = BCrypt.hashpw(passwordConfirmation, BCrypt.gensalt());
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

    public List<Guideline> getGuidelineListToDo() {
        return guidelineListToDo;
    }

    public void setGuidelineListToDo(List<Guideline> guidelineListToDo) {
        this.guidelineListToDo = guidelineListToDo;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public List<LoggerUser> getLoggerUserList() {
        return loggerUserList;
    }

    public void setLoggerUserList(List<LoggerUser> loggerUserList) {
        this.loggerUserList = loggerUserList;
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

    @PrePersist
    public void prePersist() {
        this.password = BCrypt.hashpw(this.getPassword(), BCrypt.gensalt());
        this.passwordConfirmation = password;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.getPassword());
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", nameFirst='" + nameFirst + '\'' +
//                ", nameLast='" + nameLast + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}