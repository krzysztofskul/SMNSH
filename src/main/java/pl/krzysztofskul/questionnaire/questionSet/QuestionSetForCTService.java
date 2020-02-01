package pl.krzysztofskul.questionnaire.questionSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionSetForCTService {

    private QuestionSetForCTRepo questionSetForCTRepo;

    @Autowired
    public QuestionSetForCTService(QuestionSetForCTRepo questionSetForCTRepo) {
        this.questionSetForCTRepo = questionSetForCTRepo;
    }

    public void save(QuestionSetForCT questionSetForCT) {
        questionSetForCTRepo.save(questionSetForCT);
    }

}
