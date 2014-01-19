package pl.pawelszczerbicki.smarthome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pawelszczerbicki.smarthome.device.DeviceService;
import pl.pawelszczerbicki.smarthome.device.domain.DeviceAction;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 26.09.13
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/")
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("devices", deviceService.find(true));
        model.addAttribute("actions", DeviceAction.values());
        model.addAttribute("pinAmount", 12);
        return "dashboard";
    }
}