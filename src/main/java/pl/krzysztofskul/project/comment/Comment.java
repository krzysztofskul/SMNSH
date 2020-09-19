package pl.krzysztofskul.project.comment;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {

    /**params*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    @ManyToOne
    private Project project;

    private String message;

    private LocalDate dateOfCreation;

    /**constructors*/

    public Comment() {
    }

    /**getters and setters*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**methods*/

}
