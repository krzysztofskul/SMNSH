package pl.krzysztofskul.subcontractor;

import pl.krzysztofskul.company.CompanyType;
import pl.krzysztofskul.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subcontractor {

    /** global fields */

//    public static List<Subcontractor> testSubcontractors = new ArrayList<>();

    /** local/entity fields */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private CompanyType type;

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private int streetNumber;
    
    private String email;

//    @OneToMany(mappedBy = "subcontractor")
//    private List<User> employeeList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "subcontractor", cascade = CascadeType.ALL)
//    private List<Project> projectList = new ArrayList<>();

    @OneToMany(mappedBy = "subcontractor")
    private List<Project> projectList = new ArrayList<>();

    /** constructors */

    public Subcontractor() {
    }

    /** getters and setters */

//    public static List<Subcontractor> getTestSubcontractors() {
//        return testSubcontractors;
//    }
//
//    public static void setTestSubcontractors(List<Subcontractor> testSubcontractors) {
//        Subcontractor.testSubcontractors = testSubcontractors;
//    }

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

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

//    public List<User> getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(List<User> employee) {
//        this.employee = employee;
//    }
//

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /** methods */

//    public void addProject(Project project) {
//        this.projectList.add(project);
//    }
//
//    public void removeProject(Project project) {
//        this.projectList.remove(project);
//    }

}
