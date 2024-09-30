package pl.krzysztofskul.smnsh4.Company.qualityrate;

public enum QualityrateEnum {

	WHITE(1, "BIAŁY", "WHITE", "", ""),
	GREEN(2, "ZIELONY", "GREEN", "", ""),
	YELLOW(3, "ŻÓŁTY", "YELLOW", "", ""),
	RED(4, "CZERWONY", "RED", "", ""),
	BLACK(5, "CZARNY", "BLACK", "", "");

	
	private int value;
	private String namePL;
	private String nameEN;
	private String descriptionPL;
	private String descriptionEN;

	/**
	 * @param value
	 * @param namePL
	 * @param nameEN
	 * @param descriptionPL
	 * @param descriptionEN
	 */
	private QualityrateEnum(int value, String namePL, String nameEN, String descriptionPL, String descriptionEN) {
		this.value = value;
		this.namePL = namePL;
		this.nameEN = nameEN;
		this.descriptionPL = descriptionPL;
		this.descriptionEN = descriptionEN;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getNamePL() {
		return namePL;
	}

	public void setNamePL(String namePL) {
		this.namePL = namePL;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	public String getDescriptionPL() {
		return descriptionPL;
	}

	public void setDescriptionPL(String descriptionPL) {
		this.descriptionPL = descriptionPL;
	}

	public String getDescriptionEN() {
		return descriptionEN;
	}

	public void setDescriptionEN(String descriptionEN) {
		this.descriptionEN = descriptionEN;
	}
	
	
	
}
