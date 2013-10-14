package pl.pawelszczerbicki.smarthome.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawelszczerbicki.smarthome.auth.UserDto;
import pl.pawelszczerbicki.smarthome.utils.ControllerUtils;
import pl.pawelszczerbicki.smarthome.utils.MessageResolver;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 05.10.13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class AccountController {

    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDtoValidator accountDtoValidator;

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String addAccount(@Valid AccountDto account, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", controllerUtils.transformErrorsToCode(result.getAllErrors()));
            addStandardRegisterAttributes(new UserDto(), model, account);
            return "register";
        }
        accountService.saveWithUser(account);
        model.addAttribute("success", MessageResolver.ACCOUNT_ADDED_SUCCESSFULLY);
        addStandardRegisterAttributes(new UserDto(), model, new AccountDto());
        return "register";
    }

    @InitBinder("accountDto")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(accountDtoValidator);
    }

    private void addStandardRegisterAttributes(UserDto user, Model model, AccountDto account) {
        user.clearPassword();
        model.addAttribute("user", user);
        model.addAttribute("account", account);
    }
}
