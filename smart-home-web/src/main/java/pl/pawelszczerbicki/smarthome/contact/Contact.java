package pl.pawelszczerbicki.smarthome.contact;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Document(collection = "contacts")
public class Contact {

    private String id;

    private String name;

    @Email(message = "contact.malformed.email")
    @NotEmpty(message = "contact.malformed.email")
    private String email;

    private String phone;

    private String message;
}
