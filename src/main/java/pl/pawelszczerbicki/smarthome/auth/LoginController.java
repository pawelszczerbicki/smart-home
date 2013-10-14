package pl.pawelszczerbicki.smarthome.auth;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pawelszczerbicki.smarthome.account.Account;
import pl.pawelszczerbicki.smarthome.account.AccountDto;
import pl.pawelszczerbicki.smarthome.account.AccountService;
import pl.pawelszczerbicki.smarthome.utils.ControllerUtils;
import pl.pawelszczerbicki.smarthome.utils.MessageResolver;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 23.09.13
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {

    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDtoValidator userDtoValidator;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register(Model model) {
        addStandardRegisterAttributes(new UserDto(), model, new AccountDto());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid UserDto user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", controllerUtils.transformErrorsToCode(result.getAllErrors()));
            addStandardRegisterAttributes(user, model, new AccountDto());
            return "register";
        }
        Account a = accountService.getByDomain(user.getDomain());
        userService.save(user, a);
        addStandardRegisterAttributes(new UserDto(), model, new AccountDto());
        model.addAttribute("success", MessageResolver.USER_ADDED_SUCCESSFULLY);
        return "register";
    }


    @RequestMapping(value = "/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @RequestMapping(value = "/forgot-password")
    public String forgotPassword(@RequestParam String username, Model model) {
        User user = userService.get(username);
        if (StringUtils.isBlank(username) || user == null)
            model.addAttribute("errors", MessageResolver.USER_NOT_EXISTS);
        else{
            userService.changePassword(user);
            model.addAttribute("success", MessageResolver.USER_PASSWORD_CHANGED);
        }
        return "login";
    }

    @InitBinder("userDto")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userDtoValidator);
    }

    private void addStandardRegisterAttributes(UserDto user, Model model, AccountDto account) {
        user.clearPassword();
        model.addAttribute("user", user);
        model.addAttribute("account", account);
    }
}
