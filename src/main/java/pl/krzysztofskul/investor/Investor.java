package pl.krzysztofskul.investor;

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

    @OneToMany(mappedBy = "investor")
    private List<Project> projectList = new ArrayList<>();

    /**
     * constr.
     */

    public Investor() {
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

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projects) {
        this.projectList = projects;
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
