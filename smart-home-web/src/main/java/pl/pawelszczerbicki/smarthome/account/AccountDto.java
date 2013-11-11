package pl.pawelszczerbicki.smarthome.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 29.09.13
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
public class AccountDto {

    private String domain;

    private String email;

    private String password;

}
