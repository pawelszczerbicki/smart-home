package pl.pawelszczerbicki.smarthome.device;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

//TODO change to Spring Data
@Repository
public class DeviceDao extends GenericDao<Device> {

    public DeviceDao() {
        super(Device.class);
    }

    public List<Device> find(String accountId, boolean active) {
        return mongoTemplate.find(new Query(Criteria
                .where("accountId").is(accountId)
                .and("active").is(active))
                .with(new Sort(Sort.Direction.DESC, "createdAt")),
                Device.class);
    }

    public void setActive(String id, boolean active) {
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)), new Update().set("active", active), Device.class);
    }

    public void removeAction(String id, String action) {
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)), new Update().pull("actions", action), Device.class);
    }

    public void addAction(String id, String action) {
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)), new Update().addToSet("actions", action), Device.class);
    }
}
