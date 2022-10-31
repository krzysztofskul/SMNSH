package pl.krzysztofskul.company.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyTypeService {

    private CompanyTypeRepo companyTypeRepo;
    private boolean isCompanyTypesCreated = false;

    @Autowired
    public CompanyTypeService(CompanyTypeRepo companyTypeRepo) {
        this.companyTypeRepo = companyTypeRepo;
    }

    /** CRUD */
    public void save(CompanyType companyType) {
        companyTypeRepo.save(companyType);
    }

    public List<CompanyType> loadAll() {
        return companyTypeRepo.findAll();
    }

    public CompanyType loadById(Long id) {
        return  (companyTypeRepo.findById(id).get());
    }

    /** NO-CRUD */
    public void createCompanyTypesAndSaveToDB() {
    	if (isCompanyTypesCreated == false) {
	        for (CompanyTypeEnum companyTypeEnum : CompanyTypeEnum.values()) {
	            CompanyType companyType = new CompanyType();
	            companyType.setCode(companyTypeEnum.getCode());
	            companyType.setName(companyTypeEnum.getName());
	            this.save(companyType);
	            this.isCompanyTypesCreated = true;
	        }
    	}
    }


}
