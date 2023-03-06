package pl.krzysztofskul.SapCustomer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import pl.krzysztofskul.smnsh4.Company.Company;

@Entity
public class SapCustomer {

	@Id
	private String numberSap;
	
	private String name;
	
	private String postalCode;
	
	private String location;
	
	private String streetName;
	
	private String name2;
	
	private String name3;
	
	private String name4;
	
	private String nip;
	
	private String ifa;
	
	private String telephone1;
	
	private String faxNumber;
	
	@OneToOne(mappedBy = "sapCustomer")
	private Company company;

	public SapCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SapCustomer(String numberSap, String name, String postalCode, String location, String streetName, String name2,
			String name3, String name4, String nip, String ifa, String telephone1, String faxNumber) {
		super();
		this.numberSap = numberSap;
		this.name = name;
		this.postalCode = postalCode;
		this.location = location;
		this.streetName = streetName;
		this.name2 = name2;
		this.name3 = name3;
		this.name4 = name4;
		this.nip = nip;
		this.ifa = ifa;
		this.telephone1 = telephone1;
		this.faxNumber = faxNumber;
	}



	public String getNumberSap() {
		return numberSap;
	}

	public void setNumberSap(String numberSap) {
		this.numberSap = numberSap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getIfa() {
		return ifa;
	}

	public void setIfa(String ifa) {
		this.ifa = ifa;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
		
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
