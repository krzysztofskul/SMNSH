package pl.krzysztofskul.investor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	public void createInvestorsFromSapImport() {
		List<SapCustomer> sapCustomersFromDb = sapCustomerService.loadAll();
		
		for (SapCustomer sapCustomer : sapCustomersFromDb) {
			Investor investor = new Investor(sapCustomer);
			investorService.save(investor);
		}
		
	}


	
}
