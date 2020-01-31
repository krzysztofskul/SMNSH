package pl.krzysztofskul.questionSet;

import javax.persistence.*;

@Entity
public class QuestionSetForXRAY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isXrayProtectionToDesign;

    private int sourceImageDistanceRequired;


    public QuestionSetForXRAY() {
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

    public int getSourceImageDistanceRequired() {
        return sourceImageDistanceRequired;
    }

    public void setSourceImageDistanceRequired(int sourceImageDistanceRequired) {
        this.sourceImageDistanceRequired = sourceImageDistanceRequired;
    }

}
