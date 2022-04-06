package pl.krzysztofskul.project.comment;

import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime dateOfCreation;

    /**constructors*/

    public Comment() {
    }
    
    

    public Comment(Project project, User author, String message) {
		super();
		this.project = project;
		this.author = author;
		this.message = message;
		this.dateOfCreation = LocalDateTime.now();
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

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**methods*/

}
