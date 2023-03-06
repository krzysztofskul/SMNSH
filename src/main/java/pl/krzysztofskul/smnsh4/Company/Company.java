package pl.krzysztofskul.smnsh4.Company;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import pl.krzysztofskul.SapCustomer.SapCustomer;
import pl.krzysztofskul.smnsh4.Company.CompanyCategory.CompanyCategory;
import pl.krzysztofskul.smnsh4.Company.Employee.Employee;
import pl.krzysztofskul.smnsh4.ContactDetails.ContactDetails;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne
	private SapCustomer sapCustomer;
	
	@OneToOne
	private ContactDetails contactDetails;
	
	@ManyToMany
	@JoinTable(
			name = "company_category",
			joinColumns = @JoinColumn(name  = "company_id"),
			inverseJoinColumns = @JoinColumn(name = "comapnyCategory_id")
	)
	private List<CompanyCategory> companyCategoryList = new ArrayList<CompanyCategory>();
	
	@ManyToMany
	@JoinTable(
			name = "company_employee",
			joinColumns = @JoinColumn(name  = "company_id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	/**
	 * CONSTRUCTORS
	 */
	public Company() {}	
	
	public Company(Long id, String name, SapCustomer sapCustomer, ContactDetails contactDetails,
			List<CompanyCategory> companyCategoryList, List<Employee> employeeList) {
		super();
		this.id = id;
		this.name = name;
		this.sapCustomer = sapCustomer;
		this.contactDetails = contactDetails;
		this.companyCategoryList = companyCategoryList;
		this.employeeList = employeeList;
	}

	/**
	 * GETTERS AND SETTERS
	 */
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SapCustomer getSapCustomer() {
		return sapCustomer;
	}

	public void setSapCustomer(SapCustomer sapCustomer) {
		this.sapCustomer = sapCustomer;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<CompanyCategory> getCompanyCategoryList() {
		return companyCategoryList;
	}

	public void setCompanyCategoryList(List<CompanyCategory> companyCategoryList) {
		this.companyCategoryList = companyCategoryList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	/**
	 * METHODS
	 */
	
}
