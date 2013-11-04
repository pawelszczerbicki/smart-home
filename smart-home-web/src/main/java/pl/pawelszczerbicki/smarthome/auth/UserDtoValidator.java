package pl.pawelszczerbicki.smarthome.auth;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.pawelszczerbicki.smarthome.account.AccountService;
import pl.pawelszczerbicki.smarthome.utils.MessageResolver;
import pl.pawelszczerbicki.smarthome.utils.StringTools;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 05.10.13
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserDtoValidator implements Validator {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private StringTools stringTools;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", MessageResolver.USER_EMPTY_EMAIL, MessageResolver.USER_EMPTY_EMAIL);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", MessageResolver.USER_EMPTY_PASSWORD, MessageResolver.USER_EMPTY_PASSWORD);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "domain", MessageResolver.USER_EMPTY_DOMAIN, MessageResolver.USER_EMPTY_DOMAIN);
        UserDto u = (UserDto) o;

        if (!stringTools.validEmail(u.getEmail()))
            errors.rejectValue("email", MessageResolver.USER_MALFORMED_EMAIL, MessageResolver.USER_MALFORMED_EMAIL);

        if (!accountService.accountExists(u.getDomain()))
            errors.rejectValue("domain", MessageResolver.ACCOUNT_NOT_EXISTS, MessageResolver.ACCOUNT_NOT_EXISTS);

        if (!StringUtils.isBlank(u.getEmail()) && userService.userExists(u.getEmail()))
            errors.rejectValue("email", MessageResolver.USER_EXISTS, MessageResolver.USER_EXISTS);

        if (!u.getPassword().equals(u.getConfirmPassword()))
            errors.rejectValue("password", MessageResolver.USER_PASSWORD_NOT_EQUALS, MessageResolver.USER_PASSWORD_NOT_EQUALS);
    }
}
