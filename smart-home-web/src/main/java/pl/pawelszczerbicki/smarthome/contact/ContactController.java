package pl.pawelszczerbicki.smarthome.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawelszczerbicki.smarthome.utils.ControllerUtils;
import pl.pawelszczerbicki.smarthome.utils.MessageResolver;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 26.09.13
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ContactController {

    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String sendEmail(@Valid Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", controllerUtils.transformErrorsToCode(result.getAllErrors()));
            model.addAttribute("contact", contact);
            return "contact";
        }
        contactService.contactAdmin(contact);
        model.addAttribute("success", MessageResolver.CONTACT_EMAIL_SEND);
        return "contact";
    }
}
