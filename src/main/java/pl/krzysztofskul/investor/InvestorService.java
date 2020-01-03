package pl.krzysztofskul.investor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvestorService {

    /**
     * params.
     */

    private InvestorRepo investorRepo;

    /**
     * constr.
     * @param investorRepo
     */
    @Autowired
    public InvestorService(InvestorRepo investorRepo) {
        this.investorRepo = investorRepo;
    }

    /**
     * methods CRUD
     * */

    /*** Create */

    public void save(Investor investor) {
        investorRepo.save(investor);
    }

    /*** Read */

    public List<Investor> loadAll() {
        return investorRepo.findAll();
    }

    public Investor loadById(Long id) {
        return investorRepo.findById(id).get();
    }

    /*** Update*/

    /*** Delete */
}
