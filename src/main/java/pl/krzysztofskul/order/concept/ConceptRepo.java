package pl.krzysztofskul.order.concept;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysztofskul.order.Status;

import java.util.List;

public interface ConceptRepo extends JpaRepository<Concept, Long> {

    List<Concept> findAllByStatus (Status status);

    List<Concept> findAllByStatusOrderByDateTimeDeadlineAsc(Status status);

}
