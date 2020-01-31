package pl.krzysztofskul.questionSet;

import pl.krzysztofskul.device.category.DeviceCategory;
import pl.krzysztofskul.order.concept.Concept;

import javax.persistence.*;

@Entity
public class QuestionSetForCT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private DeviceCategory deviceCategory;

    private boolean isXrayProtectionToDesign;

    @ManyToOne
    private Concept concept;

}
