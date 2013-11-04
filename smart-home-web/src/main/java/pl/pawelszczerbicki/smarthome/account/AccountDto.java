package pl.pawelszczerbicki.smarthome.account;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 29.09.13
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class AccountDto {

    private String domain;

    private String email;

    private String password;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
