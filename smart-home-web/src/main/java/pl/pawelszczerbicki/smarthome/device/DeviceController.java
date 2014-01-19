package pl.pawelszczerbicki.smarthome.device;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawelszczerbicki.smarthome.device.domain.DeviceAction;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 01.11.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "dashboard/device")
@Log4j
public class DeviceController {

//    private final Logger logger = getLogger(getClass());

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "add-device", method = RequestMethod.POST)
    public String addDevice(DeviceDto device) {
        log.info("device: " + device);
        deviceService.save(device);
        return "redirect:/dashboard";
    }

    @RequestMapping(value="/{deviceId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String deviceId, Model model){
        deviceService.remove(deviceId);
        getDashboardAttributes(model, true);
        return "dashboard";
    }

    @RequestMapping(value="/deactivate", method = RequestMethod.POST)
    public String deactivate(String deviceId, Model model){
        deviceService.deactivate(deviceId);
        getDashboardAttributes(model, true);
        return "dashboard";
    }

    @RequestMapping(value="/activate", method = RequestMethod.POST)
    public String activate(String deviceId, Model model){
        deviceService.activate(deviceId);
        getDashboardAttributes(model, false);
        return "deactivated";
    }

    @RequestMapping(value="/deactivated", method = RequestMethod.GET)
    public String deactivated(Model model){
        getDashboardAttributes(model, false);
        return "deactivated";
    }

    @RequestMapping(value="/add-action", method = RequestMethod.POST)
    public String addAction(Model model, String deviceId, String action){
        deviceService.addAction(deviceId, action);
        getDashboardAttributes(model, true);
        return "dashboard";
    }

    @RequestMapping(value="/remove-action", method = RequestMethod.POST)
    public String removeAction(Model model, String deviceId, String action){
        deviceService.removeAction(deviceId, action);
        getDashboardAttributes(model, true);
        return "dashboard";
    }

    private void getDashboardAttributes(Model model, boolean active) {
        model.addAttribute("devices", deviceService.find(active));
        model.addAttribute("actions", DeviceAction.values());
        model.addAttribute("pinAmount", 12);
    }
}
