package pl.krzysztofskul.smnsh4.Company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryEnum;

@Controller
@RequestMapping(name = "/smnsh4/companies")
public class CompanyController {

	CompanyService companyService;
	
	/**
	 * Constructor
	 */
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@ModelAttribute("subcontractorsForRoomAdaptation")
	public List<Company> getAllSubcontractorsForRoomAdaptations() {
		return companyService.loadAllByCompanyCategoryEnum(CompanyCategoryEnum.SUBCONTRACTOR_ROOM_ADAPTATION);
	}
}
