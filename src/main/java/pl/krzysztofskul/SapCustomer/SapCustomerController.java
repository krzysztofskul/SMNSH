package pl.krzysztofskul.SapCustomer;

import java.util.ArrayList;
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
	public String importSapCustomers() {
		//import from xls
		//List<SapCustomer> sapCustomers = RecipientScanner.getRecipientScanner().readCSV();
		
		//create in app
		List<SapCustomer> sapCustomers = new ArrayList<SapCustomer>();
		sapCustomers.add(new SapCustomer("010101", "Demo Med Investments sp. z o.o.", "09-099", "Warszawa", "ul. Testowa", "99", "", "", "011-099099", "IFA0909", "+45 909 099 099", "22 099 099 099"));
		sapCustomers.add(new SapCustomer("020202", "Demo Medical Invest sp. z o.o..", "88-088", "Kraków", "ul. Demonstracyjna", "29", "", "", "022-050505", "IFA0202", "+45 909 088 088", "22 099 088 088"));
		sapCustomers.add(new SapCustomer("030303", "Test Med-Invest sp. z o.o..", "77-077", "Poznań", "ul. Testowo-Demonstracyjna", "39", "", "", "033-050505", "IFA0303", "+45 909 088 088", "22 099 088 088"));
		
		for (SapCustomer sapCustomer : sapCustomers) {
			sapCustomerService.save(sapCustomer);
		}
		return "redirect:/create-investors-from-sap-import";
	}
	
}
