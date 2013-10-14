package pl.pawelszczerbicki.smarthome.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.pawelszczerbicki.smarthome.email.Email;
import pl.pawelszczerbicki.smarthome.email.EmailService;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ContactService {

    @Value("${admin.email}")
    private String adminEmail;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ContactDao contactDao;

    public void contactAdmin(Contact contact) {
        emailService.send(new Email(adminEmail, formatSubject(contact.getName(), contact.getPhone()), formatMessage(contact.getMessage(), contact.getEmail())));
        contactDao.save(contact);
    }

    private String formatMessage(String message, String email) {
        return new StringBuilder(message).append(", ").append(email).toString();
    }


    private String formatSubject(String name, String phone) {
        return new StringBuilder(name).append(", ").append(phone).toString();
    }
}
