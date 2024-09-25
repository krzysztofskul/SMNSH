package pl.krzysztofskul.smnsh4.Company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategory;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryEnum;

@Service
@Transactional
public class CompanyService {

	private CompanyRepo companyRepo;

	/**
	 * Constructor
	 */
	@Autowired
	public CompanyService(CompanyRepo companyRepo) {
		this.companyRepo = companyRepo;
	}
	
	public Company saveAndReturn(Company company) {
		return companyRepo.save(company);
	}
	
	public List<Company> loadAllByCompanyCategoryEnum(CompanyCategoryEnum comCatEnum) {
		List<Company> allCompanies = companyRepo.findAll();
		List<Company> companiesFiltered = new ArrayList<Company>();
		for (Company company : allCompanies) {
			Hibernate.initialize(company.getCompanyCategoryList());
		}
		for (Company company : allCompanies) {
			for (CompanyCategory companyCategory : company.getCompanyCategoryList()) {
				if (companyCategory.getCompanyCategoryEnum().equals(comCatEnum)) {
					companiesFiltered.add(company);
				}
			}
		}
		return companiesFiltered;
	}

	public List<Company> loadAll() {
		return companyRepo.findAll();
	}
	
}
