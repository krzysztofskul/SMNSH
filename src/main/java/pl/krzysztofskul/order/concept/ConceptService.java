package pl.krzysztofskul.order.concept;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.order.Status;

import java.util.List;

@Service
@Transactional
public class ConceptService {

    /**
     * params.
     */

    private ConceptRepo conceptRepo;

    /**
     * constr.
     * @param conceptRepo
     */
    @Autowired
    public ConceptService(ConceptRepo conceptRepo) {
        this.conceptRepo = conceptRepo;
    }

    /**
     * methods CRUD
     * */

    /*** Create */

    public void save(Concept concept) {
        conceptRepo.save(concept);
    }

    /*** Read */

    public List<Concept> loadAll() {
        return conceptRepo.findAll();
    }

    public List<Concept> loadAllByStatus (Status status) {
        return conceptRepo.findAllByStatus(status);
    }

    public List<Concept> findAllByStatusOrderByDateTimeDeadlineAsc (Status status) {
        return conceptRepo.findAllByStatusOrderByDateTimeDeadlineAsc(status);
    }

    public Concept loadById(Long id) {
        return conceptRepo.findById(id).get();
    }

    public Concept loadByIdWithAll(Long id) {
        Concept concept = conceptRepo.findById(id).get();
        Hibernate.initialize(concept.getDevice());
        Hibernate.initialize(concept.getAuthor());
        Hibernate.initialize(concept.getGuideline());
        return concept;
    }

    /*** Update*/

    /*** Delete */

    public void deleteById(Long id) {
        conceptRepo.deleteById(id);
    }

}
