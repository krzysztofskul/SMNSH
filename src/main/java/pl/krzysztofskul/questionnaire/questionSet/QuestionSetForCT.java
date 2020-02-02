package pl.krzysztofskul.questionnaire.questionSet;

import pl.krzysztofskul.questionnaire.QuestionForm;

import javax.persistence.*;

@Entity
public class QuestionSetForCT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isXrayProtectionToDesign;

    @OneToOne(mappedBy = "questionSetForCT")
    private QuestionForm questionForm;

    public QuestionSetForCT() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isXrayProtectionToDesign() {
        return isXrayProtectionToDesign;
    }

    public void setXrayProtectionToDesign(boolean xrayProtectionToDesign) {
        isXrayProtectionToDesign = xrayProtectionToDesign;
    }

    public QuestionForm getQuestionForm() {
        return questionForm;
    }

    public void setQuestionForm(QuestionForm questionForm) {
        this.questionForm = questionForm;
    }
}
