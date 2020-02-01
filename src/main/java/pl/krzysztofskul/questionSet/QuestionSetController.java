package pl.krzysztofskul.questionSet;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionSetController {

    private QuestionFormService questionFormService;
    private QuestionSetForMRIService questionSetForMRIService;

    @Autowired
    public QuestionSetController(
            QuestionFormService questionFormService,
            QuestionSetForMRIService questionSetForMRIService
    ) {
        this.questionFormService = questionFormService;
        this.questionSetForMRIService = questionSetForMRIService;
    }

    @PostMapping("/questionSet/save")
    public String questionSet(
            @ModelAttribute("questionSetForMRI") QuestionSetForMRI questionSetForMRI
    ) {
        //questionFormService.save(questionSetForMRI.getQuestionForm());
        QuestionForm questionForm = questionFormService.loadById(questionSetForMRI.getQuestionForm().getId());
        questionSetForMRI.setQuestionForm(questionForm);
        questionSetForMRIService.save(questionSetForMRI);
        return "redirect:/users/details/"+questionSetForMRI.getQuestionForm().getConcept().getAuthor().getId();
    }

}
