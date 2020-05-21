package pl.krzysztofskul.project;

import pl.krzysztofskul.attachment.Attachment;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.logger.loggerProject.LoggerProject;
import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String investor;

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

    private String sls;

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

    private String trainings;

    private String remarks;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Concept> conceptList = new ArrayList<>();

    @OneToOne(mappedBy = "project")
    private Attachment attachment;

    @OneToMany(mappedBy = "project")
    private List<LoggerProject> loggerProjectList;

    public Project() {
        this.deadline = LocalDateTime.now().plusDays(Long.parseLong("1"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
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

    public String getSls() {
        return sls;
    }

    public void setSls(String sls) {
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

    public void setBuildingContractor(String buildingContractr) {
        this.buildingContractor = buildingContractr;
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
}
