package pl.krzysztofskul.questionSet;

import javax.persistence.*;

@Entity
public class QuestionSetForCT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isXrayProtectionToDesign;


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

}
