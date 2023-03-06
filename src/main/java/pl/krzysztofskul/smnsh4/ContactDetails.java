package pl.krzysztofskul.smnsh4;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.krzysztofskul.smnsh4.Company.Company;

//@Entity
public class ContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Address address;
	
	private Map<String, String> phoneNumbers;
	
	private Map<String, String> emailAdresses;
	
	private String website;
	
	/*
	 * CONSTRUCTORS
	 */
	
	public ContactDetails() {}
	
	public ContactDetails(Long id, Address address, Map<String, String> phoneNumbers, Map<String, String> emailAdresses,
			String website) {
		super();
		this.id = id;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
		this.emailAdresses = emailAdresses;
		this.website = website;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumbers
	 */
	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return the emailAdresses
	 */
	public Map<String, String> getEmailAdresses() {
		return emailAdresses;
	}

	/**
	 * @param emailAdresses the emailAdresses to set
	 */
	public void setEmailAdresses(Map<String, String> emailAdresses) {
		this.emailAdresses = emailAdresses;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}	
	
	
	
}
