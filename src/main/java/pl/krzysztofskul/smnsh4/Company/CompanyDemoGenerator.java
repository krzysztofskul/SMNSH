package pl.krzysztofskul.smnsh4.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.SapCustomer.SapCustomer;
import pl.krzysztofskul.initDB.InitDataGenerator;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategory;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryEnum;
import pl.krzysztofskul.smnsh4.Company.Employee.Employee;
import pl.krzysztofskul.smnsh4.ContactDetails.ContactDetailsDemoGenerator;

@Service
public class CompanyDemoGenerator implements InitDataGenerator<Company> {

	private ContactDetailsDemoGenerator contactDetailsDemoGenerator;
	
	private List<Company> companyDemoList = new ArrayList<Company>();	
	
	/**
	 * @param contactDetailsDemoGenerator
	 */
	@Autowired
	public CompanyDemoGenerator(ContactDetailsDemoGenerator contactDetailsDemoGenerator) {
		this.contactDetailsDemoGenerator = contactDetailsDemoGenerator;
	}



	@Override
	public List<Company> initDataAndReturn() {
		for (int i = 0; i < new Random().nextInt(5)+5; i++) {
			
			List<CompanyCategory> companyCategoryList = new ArrayList<CompanyCategory>();
			companyCategoryList.add(new CompanyCategory(CompanyCategoryEnum.INVESTOR));
			companyCategoryList.add(new CompanyCategory(CompanyCategoryEnum.USER));
			
			companyDemoList.add(
						
						new Company(
									Long.valueOf("0"),
									LoremIpsum.getInstance().getName(),
									new SapCustomer(),
									contactDetailsDemoGenerator.getDemoContactDetails(),
									companyCategoryList,
									new ArrayList<Employee>()
								)
					
					);
		}
		return companyDemoList;
	}

	
	
}
