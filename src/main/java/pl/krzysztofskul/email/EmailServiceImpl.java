package pl.krzysztofskul.email;

import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private ApplicationContext context;
//    @Autowired
//    private EmailCredentials emailCredentials;

    public void sendHtmlMessage(String to, String subject, String text) {

            JavaMailSenderImpl sender = new JavaMailSenderImpl();
//            context.getBean(JavaMailSenderImpl.class).setPassword(emailCredentials.getPassPlain());

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
            System.out.println("Message has been sent successfully!");

    }

    public void sendHtmlMessageWithAttachment(String to, String subject, String text, String attachmentFileName, File file) {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        context.getBean(JavaMailSenderImpl.class).setPassword(emailCredentials.getPassPlain());

        MimeMessage message = sender.createMimeMessage();

        //MimeMessageHelper helper = new MimeMessageHelper(message);
        MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, CharEncoding.UTF_8);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            helper.addAttachment(attachmentFileName, file);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

        emailSender.send(message);
        System.out.println("Message with attachment has been sent successfully!");

}
    
}
