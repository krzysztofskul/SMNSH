package pl.krzysztofskul.smnsh4.Company;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategory;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryEnum;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategoryService;

@Controller
@RequestMapping("/smnsh4/companies")
public class CompanyController {

	CompanyService companyService;
	CompanyCategoryService companyCategoryService;
	
	/**
	 * Constructor
	 */
	@Autowired
	public CompanyController(
			CompanyService companyService,
			CompanyCategoryService companyCategoryService
			) {
		this.companyService = companyService;
		this.companyCategoryService = companyCategoryService;
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
	public String getNew(
			Model model,
			@RequestParam(name = "category", required = false) String category,
			@RequestParam(name = "edit", required = false) String edit
			) {

		Company company = new Company();

		switch (category) {
			case "investor": {
				company.addCompanyCategory(companyCategoryService.loadByCompanyCategoryEnum(CompanyCategoryEnum.INVESTOR));
				break;
			}
			case "subcontractor": {
				company.addCompanyCategory(companyCategoryService.loadByCompanyCategoryEnum(CompanyCategoryEnum.SUBCONTRACTOR_ROOM_ADAPTATION));
				break;
			}
		}

		model.addAttribute(company);

		return "company/details";
	}
		
	@GetMapping("/details/{companyId}")
	public String getDetails(
				@PathVariable(name ="companyId") Long companyId,
				@RequestParam(name = "edit", required = false) String edit,
				Model model
			) {
		Company company = companyService.loadByIdWithCompanyCategoryList(companyId);
		model.addAttribute("company", company);
//		if (null != edit) {
//			if (edit.equals("true")) {
//				return "company/details?edit=true";	
//			}	
//		}
		return "company/details";
	}
	
	@PostMapping("/save")
	public String postSave(
				@ModelAttribute("company") Company company
			) {
		Company companySaved = companyService.saveAndReturn(company);
		
		return "redirect:/smnsh4/companies/details/"+companySaved.getId();
	}
	
}
