package pl.pawelszczerbicki.smarthome.account;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.pawelszczerbicki.smarthome.auth.UserService;
import pl.pawelszczerbicki.smarthome.utils.MessageResolver;
import pl.pawelszczerbicki.smarthome.utils.StringTools;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 05.10.13
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AccountDtoValidator implements Validator {

    @Autowired
    private StringTools stringTools;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AccountDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "domain", MessageResolver.ACCOUNT_EMPTY_DOMAIN, MessageResolver.ACCOUNT_EMPTY_DOMAIN);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", MessageResolver.ACCOUNT_EMPTY_EMAIL, MessageResolver.ACCOUNT_EMPTY_EMAIL);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", MessageResolver.ACCOUNT_EMPTY_PASSWORD, MessageResolver.ACCOUNT_EMPTY_PASSWORD);
        AccountDto a = (AccountDto) target;

        if (stringTools.validEmail(a.getEmail()))
            errors.rejectValue("email", MessageResolver.ACCOUNT_MALFORMED_EMAIL, MessageResolver.ACCOUNT_MALFORMED_EMAIL);

        if (!StringUtils.isBlank(a.getDomain()) && accountService.accountExists(a.getDomain()))
            errors.rejectValue("domain", MessageResolver.ACCOUNT_EXISTS, MessageResolver.ACCOUNT_EXISTS);

        if (!StringUtils.isBlank(a.getEmail()) && userService.userExists(a.getEmail()))
            errors.rejectValue("email", MessageResolver.USER_EXISTS, MessageResolver.USER_EXISTS);
    }
}
