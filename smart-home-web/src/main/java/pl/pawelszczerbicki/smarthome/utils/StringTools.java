package pl.pawelszczerbicki.smarthome.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 06.10.13
 * Time: 10:20
 * To change this template use File | Settings | File Templates.
 */
@Component
public class StringTools {

    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String RESET_PASSWORD_SUBJECT = "Smart home - new password";
    public static final String RESET_PASSWORD_CONTENT = "Your new password is: %s";

    public boolean validEmail(String s) {
        return Pattern.compile(EMAIL_PATTERN).matcher(s).matches();
    }

    public String formatContent(String s){
        return  String.format(RESET_PASSWORD_CONTENT, s);
    }
}
