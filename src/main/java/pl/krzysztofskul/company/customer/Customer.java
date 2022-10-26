package pl.krzysztofskul.company.customer;

import javax.persistence.Entity;

import pl.krzysztofskul.company.Company;

@Entity
public class Customer extends Company {

	private String noSAP;
	
	private String noNIP;
	
	private String noIFA;
	
}
