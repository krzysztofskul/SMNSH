package pl.krzysztofskul.questionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.krzysztofskul.questionnaire.questionSet.*;

@Controller
public class QuestionFormController {

    private QuestionFormService questionFormService;
    private QuestionSetForMRIService questionSetForMRIService;
    private QuestionSetForCTService questionSetForCTService;
    private QuestionSetForXRAYService questionSetForXRAYService;

    @Autowired
    public QuestionFormController(
            QuestionFormService questionFormService,
            QuestionSetForMRIService questionSetForMRIService,
            QuestionSetForCTService questionSetForCTService,
            QuestionSetForXRAYService questionSetForXRAYService
    ) {
        this.questionFormService = questionFormService;
        this.questionSetForMRIService = questionSetForMRIService;
        this.questionSetForCTService = questionSetForCTService;
        this.questionSetForXRAYService = questionSetForXRAYService;
    }

    @PostMapping("/questionSetMRI/save")
    public String questionSet(
            @ModelAttribute("questionSetForMRI") QuestionSetForMRI questionSetForMRI
    ) {
        QuestionForm questionForm = questionFormService.loadById(questionSetForMRI.getQuestionForm().getId());
        questionSetForMRI.setQuestionForm(questionForm);
        questionSetForMRIService.save(questionSetForMRI);
        return "redirect:/users/details/"+questionSetForMRI.getQuestionForm().getConcept().getAuthor().getId();
    }

    @PostMapping("/questionSetCT/save")
    public String questionSet(
            @ModelAttribute("questionSetForCT") QuestionSetForCT questionSetForCT
    ) {
        QuestionForm questionForm = questionFormService.loadById(questionSetForCT.getQuestionForm().getId());
        questionSetForCT.setQuestionForm(questionForm);
        questionSetForCTService.save(questionSetForCT);
        return "redirect:/users/details/"+questionSetForCT.getQuestionForm().getConcept().getAuthor().getId();
    }

    @PostMapping("/questionSetXRAY/save")
    public String questionSet(
            @ModelAttribute("questionSetForXRAY") QuestionSetForXRAY questionSetForXRAY
    ) {
        QuestionForm questionForm = questionFormService.loadById(questionSetForXRAY.getQuestionForm().getId());
        questionSetForXRAY.setQuestionForm(questionForm);
        questionSetForXRAYService.save(questionSetForXRAY);
        return "redirect:/users/details/"+questionSetForXRAY.getQuestionForm().getConcept().getAuthor().getId();
    }

}
