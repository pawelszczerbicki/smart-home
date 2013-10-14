package pl.pawelszczerbicki.smarthome.device;

import org.springframework.stereotype.Repository;
import pl.pawelszczerbicki.smarthome.commons.GenericDao;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 23:15
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DeviceDao extends GenericDao<Device> {

    public DeviceDao() {
        super(Device.class);
    }
}
