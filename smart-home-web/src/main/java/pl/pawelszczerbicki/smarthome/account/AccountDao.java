package pl.pawelszczerbicki.smarthome.account;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.pawelszczerbicki.smarthome.commons.GenericDao;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 29.09.13
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AccountDao extends GenericDao<Account> {

    public AccountDao() {
        super(Account.class);
    }

    public Account getByDomain(String d){
        return mongoTemplate.findOne(Query.query(Criteria.where("domain").is(d)), Account.class);
    }
}
