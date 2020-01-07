package pl.krzysztofskul.order;

import pl.krzysztofskul.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class Order {

    /**
     * params.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    private String client;

    private String priority;

    private String title = "New order...";

    private String description;

    private LocalDateTime dateTimeCreated;

    private LocalDateTime dateTimeDeadline;

    /**
     * constr.
     */

    public Order() {
    }

    /**
     * getters and setters
     * @return
     */

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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public LocalDateTime getDateTimeDeadline() {
        return dateTimeDeadline;
    }

    public void setDateTimeDeadline(LocalDateTime dateTimeDeadline) {
        this.dateTimeDeadline = dateTimeDeadline;
    }

    /**
     * methods
     */
    @PrePersist
    public void prePersist() {
        this.setDateTimeCreated(LocalDateTime.now());
    }

}