package pl.krzysztofskul.questionnaire.questionSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionSetForMRIService {

    private QuestionSetForMRIRepo questionSetForMRIRepo;

    @Autowired
    public QuestionSetForMRIService(QuestionSetForMRIRepo questionSetForMRIRepo) {
        this.questionSetForMRIRepo = questionSetForMRIRepo;
    }

    public void save(QuestionSetForMRI questionSetForMRI) {
        questionSetForMRIRepo.save(questionSetForMRI);
    }

}
