package pl.krzysztofskul.investor;

import pl.krzysztofskul.SapCustomer.SapCustomer;
import pl.krzysztofskul.company.type.CompanyType;
import pl.krzysztofskul.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Investor {

    /**
     * entity params.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private CompanyType companyType;

    private String country;

    private String postalCode;

    private String city;

    private String street;

    private int number;
    
    private String contact;

    @OneToMany(mappedBy = "investor")
    private List<Project> projectList = new ArrayList<>();
   
    @OneToOne(cascade = CascadeType.ALL)
    private SapInfo sapInfo;

	/**
     * constr.
     */

    public Investor() {
    }

    public Investor(SapCustomer sapCustomer) {
    	this.id = Long.valueOf(0);
    	this.name = sapCustomer.getName() + " " +
    			sapCustomer.getName2() + " " +
    			sapCustomer.getName3() + " " +
    			sapCustomer.getName4();
    	this.companyType = null;
    	this.country = "Poland";
    	this.postalCode = sapCustomer.getPostalCode();
    	this.city = sapCustomer.getLocation();
    	this.street = sapCustomer.getStreetName();
    	this.contact = "Tel.: " + sapCustomer.getTelephone1() + "\\n Fax: " + sapCustomer.getFaxNumber();
    	this.sapInfo = new SapInfo(
    				sapCustomer.getNumberSap(),
    				sapCustomer.getNip(),
    				sapCustomer.getIfa()
    			);
    }
    
    /**
     * getters and setters
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

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projects) {
        this.projectList = projects;
    }

    public SapInfo getSapInfo() {
		return sapInfo;
	}

	public void setSapInfo(SapInfo sapInfo) {
		this.sapInfo = sapInfo;
	}

	/** methods */

    public void addProject(Project project) {
        this.projectList.add(project);
        project.setInvestor(this);
    }

    public void removeProject(Project project) {
        this.projectList.remove(project);
        project.setInvestor(null);
    }

}
