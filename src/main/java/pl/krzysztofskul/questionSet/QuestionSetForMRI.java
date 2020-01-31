package pl.krzysztofskul.questionSet;

import javax.persistence.*;

@Entity
public class QuestionSetForMRI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isFaradayCageToDesign;

    public QuestionSetForMRI() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFaradayCageToDesign() {
        return isFaradayCageToDesign;
    }

    public void setFaradayCageToDesign(boolean faradayCageToDesign) {
        isFaradayCageToDesign = faradayCageToDesign;
    }

}
