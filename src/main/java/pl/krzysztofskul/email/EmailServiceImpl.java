package pl.krzysztofskul.email;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendHtmlMessage(String to, String subject, String text) {

            JavaMailSenderImpl sender = new JavaMailSenderImpl();

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
