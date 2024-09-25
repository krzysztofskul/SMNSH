package pl.krzysztofskul.smnsh4.Company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryEnum;

@Controller
@RequestMapping("/smnsh4/companies")
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
	
	@GetMapping("/all")
	public String getAll(
			@RequestParam (name = "category", required = false) String category,
			Model model
			) {
		List<Company> companyList = new ArrayList<Company>();
		
		
		switch (category) {
		case "investor": {
			companyList.addAll(companyService.loadAllByCompanyCategoryEnum(CompanyCategoryEnum.INVESTOR));
			break;
			}
		case "subcontractor": {
			companyList.addAll(companyService.loadAllByCompanyCategoryEnum(CompanyCategoryEnum.SUBCONTRACTOR_ROOM_ADAPTATION));
			break;
			}
		default: {
			//throw new IllegalArgumentException("Unexpected value: " + category);	
			companyList.addAll(companyService.loadAll());
			break;
			}
		}
			
		model.addAttribute(companyList);
		return "company/all";
	}
	
	@GetMapping("/new")
	public String getNew(Model model) {
		Company company = new Company();
		model.addAttribute(company);
		return "company/details";
	}
	
}
