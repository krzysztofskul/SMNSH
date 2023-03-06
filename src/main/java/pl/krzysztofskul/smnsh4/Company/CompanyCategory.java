package pl.krzysztofskul.smnsh4.Company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private CompanyCategoryEnum companyCategoryEnum;

	/*
	 * constr.
	 */
	public CompanyCategory() {
	}

	/*
	 * constr.
	 */
	public CompanyCategory(CompanyCategoryEnum companyCategoryEnum) {
		this.companyCategoryEnum = companyCategoryEnum;
	}

	/*
	 * getters and setters
	 */
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public CompanyCategoryEnum getCompanyCategoryEnum() {
		return companyCategoryEnum;
	}
	
	public void setCompanyCategoryEnum(CompanyCategoryEnum companyCategoryEnum) {
		this.companyCategoryEnum = companyCategoryEnum;
	}
	
	
	
}
