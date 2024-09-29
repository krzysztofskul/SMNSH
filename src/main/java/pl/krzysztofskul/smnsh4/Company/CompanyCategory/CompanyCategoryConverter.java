package pl.krzysztofskul.smnsh4.Company.CompanyCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CompanyCategoryConverter implements Converter <String, CompanyCategory> {

	@Autowired
	CompanyCategoryService companyCategoryService;
	
	@Override
	public CompanyCategory convert(String s) {
		
		return companyCategoryService.loadById(Long.valueOf(s));
	}

}


