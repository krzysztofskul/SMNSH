package pl.krzysztofskul.order;

public enum Status {
	
	ORDERED_WAITING("OCZEKUJE", "WAITING"),
    
    IN_PROGRESS("W TOKU", "IN PROGRESS"),
    
    FINISHED("ZAKOŃCZONY", "FINISHED");
	
	private String namePL;
	private String nameEN;
	
	private Status(String namePL, String nameEN) {
		this.namePL = namePL;
		this.nameEN = nameEN;
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
	
    @Override
    public String toString() {
        return namePL + " / " + nameEN;
    }


}