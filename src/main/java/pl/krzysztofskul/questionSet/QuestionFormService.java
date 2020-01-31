package pl.krzysztofskul.questionSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionFormService {

    private QuestionFormRepo questionFormRepo;

    @Autowired
    public QuestionFormService(QuestionFormRepo questionFormRepo) {
        this.questionFormRepo = questionFormRepo;
    }

    public void save(QuestionForm questionForm) {
        questionFormRepo.save(questionForm);
    }

}
