package pl.krzysztofskul.investor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.krzysztofskul.SapCustomer.SapCustomer;
import pl.krzysztofskul.SapCustomer.SapCustomerService;

@Controller
public class InvestorController {

	private InvestorService investorService;
	private SapCustomerService sapCustomerService;

	@Autowired
	private InvestorController(InvestorService investorService, SapCustomerService sapCustomerService) {
		super();
		this.investorService = investorService;
		this.sapCustomerService = sapCustomerService;
	}
	
	@GetMapping("/create-investors-from-sap-import")
	public String createInvestorsFromSapImport() {
		List<SapCustomer> sapCustomersFromDb = sapCustomerService.loadAll();
		
		for (SapCustomer sapCustomer : sapCustomersFromDb) {
			Investor investor = new Investor(sapCustomer);
			investorService.save(investor);
		}
		return "redirect:/home";
	}

	@GetMapping("/investors/all")
	public String getInvestorsAll(
				Model model
			) {
		model.addAttribute("investors", investorService.loadAll());
		return "investors/all";
	}
	
	@GetMapping("/investors/allwithprojects")
	public String getInvestorsAllWithProjects(
			@RequestParam(required = false, name = "srotBy")
			Model model
			) {
		List<Investor> investorList = investorService.loadAllWithProjects();
		model.addAttribute("investors", investorList);
		return "investors/all";
	}
	
	
}
