package pl.krzysztofskul.smnsh4.Company.qualityrate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import pl.krzysztofskul.smnsh4.Company.Company;

@Entity
public class Qualityrate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private QualityrateEnum qualityrateEnum;
	
	@OneToMany(mappedBy = "qualityrate")
	private List<Company> companyList = new ArrayList<Company>();

	/**
	 * Constructor
	 */
	public Qualityrate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * @param qualityrateEnum
	 */
	public Qualityrate(QualityrateEnum qualityrateEnum) {
		super();
		this.qualityrateEnum = qualityrateEnum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QualityrateEnum getQualityrateEnum() {
		return qualityrateEnum;
	}

	public void setQualityrateEnum(QualityrateEnum qualityrateEnum) {
		this.qualityrateEnum = qualityrateEnum;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

}
