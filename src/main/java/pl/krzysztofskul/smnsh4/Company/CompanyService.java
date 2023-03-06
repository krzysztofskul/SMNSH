package pl.krzysztofskul.smnsh4.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

	private CompanyRepo companyRepo;

	/**
	 * @param companyRepo
	 */
	@Autowired
	public CompanyService(CompanyRepo companyRepo) {
		this.companyRepo = companyRepo;
	}
	
	public Company saveAndReturn(Company company) {
		return companyRepo.save(company);
	}
	
	
}
