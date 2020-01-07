package pl.krzysztofskul.order.concept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Concept loadById(Long id) {
        return conceptRepo.findById(id).get();
    }


    /*** Update*/

    /*** Delete */

    public void deleteById(Long id) {
        conceptRepo.deleteById(id);
    }
}
