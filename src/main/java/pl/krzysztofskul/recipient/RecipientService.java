package pl.krzysztofskul.recipient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.investor.Investor;

import java.util.List;

@Service
@Transactional
public class RecipientService {

    /**
     * params.
     */

    private RecipientRepo recipientRepo;

    /**
     * constr.
     * @param recipientRepo
     */
    @Autowired
    public RecipientService(RecipientRepo recipientRepo) {
        this.recipientRepo = recipientRepo;
    }

    /**
     * methods CRUD
     * */

    /*** Create */

    public void save(Recipient recipient) {
        recipientRepo.save(recipient);
    }

    /*** Read */

    public List<Recipient> loadAll() {
        return recipientRepo.findAll();
    }

    public Recipient loadById(Long id) {
        return recipientRepo.findById(id).get();
    }

    /*** Update*/

    /*** Delete */
}
