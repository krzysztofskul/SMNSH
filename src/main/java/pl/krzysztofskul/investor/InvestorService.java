package pl.krzysztofskul.investor;

import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.company.CompanyTypeService;
import pl.krzysztofskul.investor.builder.Builder;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class InvestorService {

    /**
     * params.
     */

    private InvestorRepo investorRepo;
    private CompanyTypeService companyTypeService;

    /**
     * constr.
     * @param investorRepo
     * @param companyTypeService
     */
    @Autowired
    public InvestorService(InvestorRepo investorRepo, CompanyTypeService companyTypeService) {
        this.investorRepo = investorRepo;
        this.companyTypeService = companyTypeService;
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

    /**
     * methods NO-CRUD
     */

    public void createTestInvestors(int number) {
        LoremIpsum loremIpsum = new LoremIpsum();
        for (int i = 0; i < number ; i++) {
            Investor investor = new Builder()
                    .name(loremIpsum.getTitle(1))
                    .companyType(companyTypeService.loadById(
                            (long) new Random().nextInt(companyTypeService.loadAll().size())+1
                    ))
                    .country(loremIpsum.getCountry())
                    .postalCode(loremIpsum.getZipCode())
                    .city(loremIpsum.getCity())
                    .street(loremIpsum.getName())
                    .number(new Random().nextInt(100)+1)
                    .build();
            this.save(investor);
        }
    }

}
