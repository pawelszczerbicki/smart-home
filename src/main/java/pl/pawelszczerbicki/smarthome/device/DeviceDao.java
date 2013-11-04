package pl.pawelszczerbicki.smarthome.device;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.pawelszczerbicki.smarthome.commons.GenericDao;
import pl.pawelszczerbicki.smarthome.device.domain.Device;

import java.util.List;

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

    public List<Device> get(String accountId) {
        return mongoTemplate.find(new Query(Criteria.where("accountId").is(accountId)), Device.class);
    }
}
