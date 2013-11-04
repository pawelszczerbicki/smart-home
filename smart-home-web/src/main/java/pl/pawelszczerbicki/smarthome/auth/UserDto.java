package pl.pawelszczerbicki.smarthome.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 28.09.13
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class UserDto {

    private String email;

    private String password;

    private String confirmPassword;

    private String domain;

    public void clearPassword() {
        this.password = null;
        this.confirmPassword = null;
    }
}
