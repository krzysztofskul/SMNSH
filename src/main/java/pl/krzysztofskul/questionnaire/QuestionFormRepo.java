package pl.krzysztofskul.questionnaire;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionFormRepo extends JpaRepository<QuestionForm, Long> {
}
