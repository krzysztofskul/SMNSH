package pl.krzysztofskul.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSMNSHService {

    private EmailSMNSHRepo emailSMNSHRepo;

    @Autowired
    public EmailSMNSHService(EmailSMNSHRepo emailSMNSHRepo) {
        this.emailSMNSHRepo = emailSMNSHRepo;
    }

    public void save(EmailSMNSH emailSMNSH) {
        emailSMNSHRepo.save(emailSMNSH);
    }

    public List<EmailSMNSH> getAllEmailSMNSHEntity() {
        return emailSMNSHRepo.findAll();
    }

    public String getPass() {
        return emailSMNSHRepo.findById(Long.parseLong("1")).get().getPassword();
    }

}
