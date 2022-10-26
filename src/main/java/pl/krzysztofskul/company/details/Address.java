package pl.krzysztofskul.company.details;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import pl.krzysztofskul.company.type.CompanyType;

@Entity
public class Address {

    private String country;

    private String postalCode;

    private String city;

    private String streetName;

    private int streetNo;
	
}
