package pl.krzysztofskul.project;

public enum  StatusProject {

	STATUS_PROJECT_0("0", "AKWIZYCJA / ACQUISITION", "AKWIZYCJA", "ACQUISITION"),
	STATUS_PROJECT_1("1", "PLANOWANIE INSTALACJI / PRELIMINARY PLANNING", "PROJEKT KONCEPCYJNY", "CONCEPTUAL PROJECT"),
	STATUS_PROJECT_2("2", "OPRACOWYWANIE WYTYCZNYCH / FINAL PLANNING", "PROJEKT WYTYCZNYCH", "GUIDELINES PROJECT"),
	STATUS_PROJECT_3("3", "ADAPTACJA POMIESZCZEŃ / ROOMS ADAPTATION", "ADAPTACJA POMIESZCZEŃ", "ROOMS ADAPTATION"),
	STATUS_PROJECT_4("4", "DOSTAWA URZĄDZEŃ / DEVICES DELIVERY", "DOSTAWA URZĄDZEŃ", "DEVICES DELIVERY"),
	STATUS_PROJECT_5("5", "INSTALACJA URZĄDZEŃ / DEVICES INSTALLATION", "INSTALACJA URZĄDZEŃ", "DEVICES INSTALLATION"),
	STATUS_PROJECT_6("6", "URUCHOMIENIE / START UP", "URUCHOMIENIE", "START UP"),
	STATUS_PROJECT_7("7", "SZKOLENIA / TRAININGS", "SZKOLENIA", "TRAININGS"),
	STATUS_PROJECT_8("8", "ZAKOŃCZONY / FINISHED", "ZAKOŃCZONY", "FINISHED"),
	STATUS_PROJECT_9("9", "ANULOWANY / CANCELLED", "ANULOWANY", "CANCELLED");

	
	private String code;
	private String name;
	private String namePL;
	private String nameEN;
	
	StatusProject(String code, String name){
		this.code = code;
		this.name = name;
	}

	private StatusProject(String code, String name, String namePL, String nameEN) {
		this.code = code;
		this.name = name;
		this.namePL = namePL;
		this.nameEN = nameEN;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	};
    
	
    
}