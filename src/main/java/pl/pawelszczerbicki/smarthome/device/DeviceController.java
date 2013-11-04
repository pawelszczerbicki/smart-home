package pl.pawelszczerbicki.smarthome.device;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.apache.log4j.Logger.getLogger;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 01.11.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "dashboard/device")
public class DeviceController {

    private final Logger logger = getLogger(getClass());

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "add-device", method = RequestMethod.POST)
    public String addDevice(DeviceDto device) {
        logger.info("device: " + device);
        deviceService.save(device);
        return "redirect:/dashboard";
    }
}
