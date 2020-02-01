package pl.krzysztofskul.device.category;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForCT;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForMRI;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForXRAY;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DeviceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @OneToMany(mappedBy = "deviceCategory", cascade = CascadeType.ALL)
    private List<Device> deviceList = new ArrayList<>();

    @OneToOne
    private QuestionSetForMRI questionSetForMRI;

    @OneToOne
    private QuestionSetForCT questionSetForCT;

    @OneToOne
    private QuestionSetForXRAY questionSetForXRAY;

    public DeviceCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public QuestionSetForMRI getQuestionSetForMRI() {
        return questionSetForMRI;
    }

    public void setQuestionSetForMRI(QuestionSetForMRI questionSetForMRI) {
        this.questionSetForMRI = questionSetForMRI;
    }

    public QuestionSetForCT getQuestionSetForCT() {
        return questionSetForCT;
    }

    public void setQuestionSetForCT(QuestionSetForCT questionSetForCT) {
        this.questionSetForCT = questionSetForCT;
    }

    public QuestionSetForXRAY getQuestionSetForXRAY() {
        return questionSetForXRAY;
    }

    public void setQuestionSetForXRAY(QuestionSetForXRAY questionSetForXRAY) {
        this.questionSetForXRAY = questionSetForXRAY;
    }
}
