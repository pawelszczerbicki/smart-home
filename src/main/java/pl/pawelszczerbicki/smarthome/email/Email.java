package pl.pawelszczerbicki.smarthome.email;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 06.10.13
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class Email {

    private String address;
    private String subject;
    private String content;

    public Email(String address, String subject, String content) {
        this.address = address;
        this.subject = subject;
        this.content = content;
    }
}
