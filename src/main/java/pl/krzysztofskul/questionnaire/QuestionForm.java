package pl.krzysztofskul.questionnaire;

import pl.krzysztofskul.order.concept.Concept;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForCT;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForMRI;
import pl.krzysztofskul.questionnaire.questionSet.QuestionSetForXRAY;

import javax.persistence.*;

@Entity
public class QuestionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Concept concept;

    @OneToOne(cascade = CascadeType.ALL)
    private QuestionSetForMRI questionSetForMRI;

    @OneToOne(cascade = CascadeType.ALL)
    private QuestionSetForCT questionSetForCT;

    @OneToOne(cascade = CascadeType.ALL)
    private QuestionSetForXRAY questionSetForXRAY;

    public QuestionForm() {
    }

    public QuestionForm(QuestionSetForXRAY questionSetForXRAY) {
        this.questionSetForXRAY = questionSetForXRAY;
    }

    public QuestionForm(QuestionSetForCT questionSetForCT) {
        this.questionSetForCT = questionSetForCT;
    }

    public QuestionForm(QuestionSetForMRI questionSetForMRI) {
        this.questionSetForMRI = questionSetForMRI;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
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
