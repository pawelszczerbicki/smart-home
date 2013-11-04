package pl.pawelszczerbicki.smarthome.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawelszczerbicki.smarthome.auth.SecurityService;
import pl.pawelszczerbicki.smarthome.device.domain.Device;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 01.11.13
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */

@Service
public class DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private SecurityService securityService;

    public void save(DeviceDto d){
        deviceDao.save(new Device(d.getName(), d.getAction(), d.getPin(), securityService.getUser().getAccount().getId()));
    }

    public List<Device> find(){
       return deviceDao.get(securityService.getUser().getAccount().getId());
    }
}
