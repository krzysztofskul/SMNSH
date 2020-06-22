package pl.krzysztofskul.company.type;

public enum CompanyTypeEnum {

    PL_SP_ZOO ("PL_SP_ZOO", "Sp z o.o."),

    PL_SA ("PL_SA", "S.A."),

    PL_SC ("PL_SC", "S.C."),
    
    DE_GMBH_AND_KG ("DE_GMBH", "GmBH & KG"),
    
    UK_LTD("UK_LTD", "Ltd."),
    
    US_CORP ("US_CORP", "Corp.");

    private String code;
    private String name;

    CompanyTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}