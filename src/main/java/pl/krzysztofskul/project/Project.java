package pl.krzysztofskul.project;

import pl.krzysztofskul.attachment.Attachment;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.logger.loggerProject.LoggerProject;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.project.comment.Comment;
import pl.krzysztofskul.project.configuration.Configuration;
import pl.krzysztofskul.subcontractor.Subcontractor;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    /** entity fields/params.*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank
    @ManyToOne
    private Investor investor;

    @NotBlank
    private String recipient;

    @NotBlank
    private String agreementNo;

//    @NotBlank
    private StatusProject status;

    @Future
    private LocalDateTime deadline;

    private String projectName;

    @ManyToOne
    private User projectManager;

    @ManyToOne
    private User sls;

    private String log;

    private String pur;

    private String pfc;

    @NotEmpty
    @ManyToMany
    @JoinTable(
            name = "projects_devices",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id")
    )
    private List<Device> deviceList;

    private String othersDeviceList;

    private String buildingContractor;

    @ManyToOne
    private Subcontractor subcontractor;

    private String trainings;

    private String remarks;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Concept> conceptList = new ArrayList<>();

    @OneToOne(mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Attachment attachment;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE/*, orphanRemoval = true*/)
    private List<LoggerProject> loggerProjectList;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Configuration> configurationList = new ArrayList<>();

    /** constructors */

    public Project() {
        this.deadline = LocalDateTime.now().plusDays(Long.parseLong("1"));
    }

    /** getters and setters */


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public StatusProject getStatus() {
        return status;
    }

    public void setStatus(StatusProject status) {
        this.status = status;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    public User getSls() {
        return sls;
    }

    public void setSls(User sls) {
        this.sls = sls;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPur() {
        return pur;
    }

    public void setPur(String pur) {
        this.pur = pur;
    }

    public String getPfc() {
        return pfc;
    }

    public void setPfc(String pfc) {
        this.pfc = pfc;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public String getOthersDeviceList() {
        return othersDeviceList;
    }

    public void setOthersDeviceList(String othersDeviceList) {
        this.othersDeviceList = othersDeviceList;
    }

    public String getBuildingContractor() {
        return buildingContractor;
    }

    public void setBuildingContractor(String buildingContractor) {
        this.buildingContractor = buildingContractor;
    }

    public Subcontractor getSubcontractor() {
        return subcontractor;
    }

    public void setSubcontractor(Subcontractor subcontractor) {
        this.subcontractor = subcontractor;
    }

    public String getTrainings() {
        return trainings;
    }

    public void setTrainings(String trainings) {
        this.trainings = trainings;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Concept> getConceptList() {
        return conceptList;
    }

    public void setConceptList(List<Concept> conceptList) {
        this.conceptList = conceptList;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public List<LoggerProject> getLoggerProjectList() {
        return loggerProjectList;
    }

    public void setLoggerProjectList(List<LoggerProject> loggerProjectList) {
        this.loggerProjectList = loggerProjectList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Configuration> getConfigurationList() {
        return configurationList;
    }

    public void setConfigurationList(List<Configuration> configurationList) {
        this.configurationList = configurationList;
    }

    /** mmethods */

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                '}';
    }
}
