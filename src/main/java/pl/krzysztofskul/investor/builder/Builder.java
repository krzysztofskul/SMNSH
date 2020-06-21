package pl.krzysztofskul.investor.builder;

import pl.krzysztofskul.company.type.CompanyType;
import pl.krzysztofskul.investor.Investor;

public final class Builder {

    private String name;

    private CompanyType companyType;
    
    private String country;

    private String postalCode;

    private String city;

    private String street;

    private int number;

    public Builder country(String country) {
        this.country = country;
        return this;
    }
    public Builder name(String name) {
        this.name = name;
        return this;
    }
    public Builder companyType(CompanyType companyType) {
        this.companyType = companyType;
        return this;
    }
    public Builder postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
    public Builder city(String city) {
        this.city = city;
        return this;
    }
    public Builder street(String street) {
        this.street = street;
        return this;
    }
    public Builder number(int number) {
        this.number = number;
        return this;
    }
    
    public Investor build() {
        Investor investor = new Investor();
        investor.setName(this.name);
        investor.setCompanyType(this.companyType);
        investor.setCountry(this.country);
        investor.setPostalCode(this.postalCode);
        investor.setCity(this.city);
        investor.setStreet(this.street);
        investor.setNumber(this.number);
        return investor;
    }
    
}
