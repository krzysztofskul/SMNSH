package pl.krzysztofskul.investor;

import com.thedeanda.lorem.LoremIpsum;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.company.type.CompanyTypeService;
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
    private SapInfoRepo sapInfoRepo;
    private CompanyTypeService companyTypeService;

    /**
     * constr.
     * @param investorRepo
     * @param companyTypeService
     */
    @Autowired
    public InvestorService(InvestorRepo investorRepo, CompanyTypeService companyTypeService, SapInfoRepo sapInfoRepo) {
        this.investorRepo = investorRepo;
        this.companyTypeService = companyTypeService;
        this.sapInfoRepo = sapInfoRepo;
    }

    /**
     * methods CRUD
     * */

    /*** Create */

    public void save(Investor investor) {
        investorRepo.save(investor);
    }
    
	public Investor saveAndReturn(Investor investor) {
		return investorRepo.save(investor);
	}

    /*** Read */

    public List<Investor> loadAll() {
        return investorRepo.findAll();
    }
    
	public List<Investor> loadAllWithProjects() {
		List<Investor> investorList = this.loadAll();
		for (Investor investor : investorList) {
			Hibernate.initialize(investor.getProjectList());
		}
		return investorList;
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

    /***
     * Methods search investor in the database by given SAP no.;
     * @param investorSapNo;
     * @return investor if found;
     * @return null if not found or other exception;
     */
	@SuppressWarnings("finally")
	public Investor loadBySapNo(String investorSapNo) {
		Investor investor = null;
		try {
			investor = sapInfoRepo.findBySapNo(investorSapNo).getInvestor();
		} catch (NullPointerException e) {
			System.err.println("App. ERROR: Not found Investor for given SAP no. in the Database !!!");
		}  catch (Exception e) {
			System.err.println("App. ERROR while searching Investor by given SAP no. !!!");
		} finally {
			return investor;	
		}
	}





}
