package pl.krzysztofskul.email;

import org.springframework.stereotype.Component;

@Component
public class EmailCredentials {

    private String login = "";
    
    private String passPlain = "";
    private String pass;
    
    private String kpdsEmailSendTo = "";
    

    private EmailCredentials() {
        this.setLogin("");
        this.setPass(passPlain);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String word) {
        this.pass = word;
    }

    public String getPassPlain() {
        return passPlain;
    }

    public void setPassPlain(String passPlain) {
        this.passPlain = passPlain;
    }

	public String getKpdsEmailSendTo() {
		return kpdsEmailSendTo;
	}

	public void setKpdsEmailSendTo(String kpdsEmailSendTo) {
		this.kpdsEmailSendTo = kpdsEmailSendTo;
	}
    
}
