package pl.krzysztofskul.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private ApplicationContext context;

    public void sendHtmlMessage(String to, String subject, String text) {

            JavaMailSenderImpl sender = new JavaMailSenderImpl();
            context.getBean(JavaMailSenderImpl.class).setPassword(EmailCredentials.getPassPlain());

            MimeMessage message = sender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message);
            try {
                helper.setTo(to);
            } catch (javax.mail.MessagingException e) {
                e.printStackTrace();
            }
            try {
                helper.setSubject(subject);
            } catch (javax.mail.MessagingException e) {
                e.printStackTrace();
            }
            try {
                helper.setText(text, true);
            } catch (javax.mail.MessagingException e) {
                e.printStackTrace();
            }

            emailSender.send(message);
            System.out.println("Message was sent successfully!");

    }

}
