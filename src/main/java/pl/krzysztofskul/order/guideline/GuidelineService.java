package pl.krzysztofskul.order.guideline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuidelineService {

    /**
     * params.
     */

    private GuidelineRepo guidelineRepo;

    /**
     * constr.
     * @param guidelineRepo
     */
    @Autowired
    public GuidelineService(GuidelineRepo guidelineRepo) {
        this.guidelineRepo = guidelineRepo;
    }

    /**
     * methods CRUD
     * */

    /*** Create */

    public void save(Guideline guideline) {
        guidelineRepo.save(guideline);
    }

    /*** Read */

    public List<Guideline> loadAll() {
        return guidelineRepo.findAll();
    }

    public Guideline loadById(Long id) {
        return guidelineRepo.findById(id).get();
    }

    /*** Update*/

    /*** Delete */
}
