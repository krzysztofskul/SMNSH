package pl.krzysztofskul.email;

public interface EmailService {
    void sendHtmlMessage(String to, String subject, String text);
}
