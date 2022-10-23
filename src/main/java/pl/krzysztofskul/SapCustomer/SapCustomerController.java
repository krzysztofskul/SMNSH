package pl.krzysztofskul.SapCustomer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krzysztofskul.recipient.RecipientScanner;

@Controller
@RequestMapping("/sapcustomers")
public class SapCustomerController {

	private SapCustomerService sapCustomerService;

	@Autowired
	public SapCustomerController(SapCustomerService sapCustomerService) {
		super();
		this.sapCustomerService = sapCustomerService;
	}
	
	/*
	 * import from csv file located od hdd
	 */
	@GetMapping("import")
	public void importSapCustomers() {
		List<SapCustomer> sapCustomers = RecipientScanner.getRecipientScanner().readCSV();
		for (SapCustomer sapCustomer : sapCustomers) {
			sapCustomerService.save(sapCustomer);
		}
	}
	
}
