package pl.pawelszczerbicki.smarthome.utils;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 29.09.13
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MessageResolver {

    public static final String ACCOUNT_NOT_EXISTS="account.not.exists";
    public static final String USER_ADDED_SUCCESSFULLY = "user.added.successfully";
    public static final String ACCOUNT_EXISTS="account.exists";
    public static final String ACCOUNT_ADDED_SUCCESSFULLY = "account.added";
    public static final String USER_EXISTS = "user.exists";
    public static final String USER_EMPTY_EMAIL = "user.empty.email";
    public static final String USER_EMPTY_PASSWORD = "user.empty.password";
    public static final String USER_EMPTY_DOMAIN = "user.empty.domain";
    public static final String USER_MALFORMED_EMAIL = "user.malformed.email";
    public static final String USER_PASSWORD_NOT_EQUALS = "user.password.not.equals";
    public static final String ACCOUNT_EMPTY_DOMAIN = "account.domain.not.null";
    public static final String ACCOUNT_EMPTY_EMAIL = "account.email.not.null";
    public static final String ACCOUNT_EMPTY_PASSWORD = "account.password.not.null";
    public static final String ACCOUNT_MALFORMED_EMAIL = "account.malformed.email";
    public static final String USER_NOT_EXISTS = "user.not.exists";
    public static final String USER_PASSWORD_CHANGED = "user.password.changed";
    public static final String CONTACT_EMAIL_SEND = "contact.email.send";
}
