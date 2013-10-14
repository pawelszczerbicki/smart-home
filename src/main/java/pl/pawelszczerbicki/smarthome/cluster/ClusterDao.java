package pl.pawelszczerbicki.smarthome.cluster;

import org.springframework.stereotype.Repository;
import pl.pawelszczerbicki.smarthome.commons.GenericDao;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ClusterDao extends GenericDao<Cluster>{

    public ClusterDao() {
        super(Cluster.class);
    }
}
