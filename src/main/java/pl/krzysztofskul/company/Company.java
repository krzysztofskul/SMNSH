package pl.krzysztofskul.company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.krzysztofskul.company.details.Address;
import pl.krzysztofskul.company.details.Contact;
import pl.krzysztofskul.company.type.CompanyType;

//@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private CompanyType companyType;
	
	private Address address;
	
	private Contact contact;
	
}
