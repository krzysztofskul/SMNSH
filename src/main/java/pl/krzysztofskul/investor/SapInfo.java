package pl.krzysztofskul.investor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SapInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "sapInfo")
	private Investor investor;
	private Long sapNo;
	private String nipNo;
	private String ifaNo;

	public SapInfo() {
	}

	public SapInfo(Long sapNo, String nipNo, String ifaNo) {
		super();
		this.sapNo = sapNo;
		this.nipNo = nipNo;
		this.ifaNo = ifaNo;
	}



	public Long getId() {
		return id;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public Long getSapNo() {
		return sapNo;
	}

	public void setSapNo(Long sapNo) {
		this.sapNo = sapNo;
	}

	public String getNipNo() {
		return nipNo;
	}

	public void setNipNo(String nipNo) {
		this.nipNo = nipNo;
	}

	public String getIfaNo() {
		return ifaNo;
	}

	public void setIfaNo(String ifaNo) {
		this.ifaNo = ifaNo;
	}

	public void setId(Long id) {
		this.id = id;
	}


}