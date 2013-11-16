package pl.pawelszczerbicki.smarthome.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 29.09.13
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Document(collection = "accounts")
public class Account implements Serializable{

    private String id;

    private String domain;

    private Date deviceUpdatedAt;

    public Account(String domain) {
        this.domain = domain;
    }
}
