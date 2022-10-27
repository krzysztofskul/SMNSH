package pl.krzysztofskul.investor;

import java.util.Collections;
import java.util.Comparator;
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
			@RequestParam(required = false, name = "sortBy") String sortBy,
			Model model
			) {
		List<Investor> investorList = investorService.loadAllWithProjects();
		
		if (null != sortBy) {
			switch (sortBy) {
			case "nameAsc": {
				Collections.sort(investorList, new Comparator<Investor>() {
	
					@Override
					public int compare(Investor i1, Investor i2) {
						return i1.getName().compareTo(i2.getName());
					}
				});
				break;
				}
			case "nameDesc": {
				Collections.sort(investorList, new Comparator<Investor>() {
	
					@Override
					public int compare(Investor i1, Investor i2) {
						return i2.getName().compareTo(i1.getName());
					}
				});
				break;
				}
			case "sapNoASC": {
				Collections.sort(investorList, new Comparator<Investor>() {
					
					@Override
					public int compare(Investor i1, Investor i2) {
						return i1.getSapInfo().getSapNo().compareTo(i2.getSapInfo().getSapNo());
					}
				});
				break;
			}
			case "sapNoDesc": {
				Collections.sort(investorList, new Comparator<Investor>() {
					
					@Override
					public int compare(Investor i1, Investor i2) {
						return i2.getSapInfo().getSapNo().compareTo(i1.getSapInfo().getSapNo());
					}
				});
				break;
			}
	
			default:
				break;
			}
		}
		
		model.addAttribute("investors", investorList);
		return "investors/all";
	}
	
	
}
