package pl.pawelszczerbicki.smarthome.email;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static org.apache.log4j.Logger.getLogger;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 06.10.13
 * Time: 23:20
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EmailService {
    private final Logger logger = getLogger(getClass());

    @Value("${email.username}")
    private String USERNAME;

    @Value("${email.password}")
    private String PASSWORD;

    @Value("${email.from}")
    private String FROM;

    private static Properties props = new Properties();

    static {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    public void send(Email email) {
        try {

            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getAddress()));
            message.setSubject(email.getSubject());
            message.setText(email.getContent());

            Transport.send(message);

        } catch (MessagingException e) {
            logger.error("Error sending email", e);
        }
    }

    private Session getSession() {
        return Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }

}
