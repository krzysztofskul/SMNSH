package pl.krzysztofskul.questionnaire.questionSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionSetForXRAYService {

    private QuestionSetForXRAYRepo questionSetForXRAYRepo;

    @Autowired
    public QuestionSetForXRAYService(QuestionSetForXRAYRepo questionSetForXRAYRepo) {
        this.questionSetForXRAYRepo = questionSetForXRAYRepo;
    }

    public void save(QuestionSetForXRAY questionSetForXRAY) {
        questionSetForXRAYRepo.save(questionSetForXRAY);
    }

}
