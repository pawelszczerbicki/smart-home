package pl.pawelszczerbicki.smarthome.auth;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import pl.pawelszczerbicki.smarthome.commons.GenericDao;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 28.09.13
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDao extends GenericDao<User> {

    public UserDao() {
        super(User.class);
    }

    public User getByUsernameOrEmail(String username){
        Criteria c = new Criteria()
                .orOperator(
                        Criteria.where("username").is(username),
                        Criteria.where("email").is(username));

        return mongoTemplate.findOne(Query.query(c), User.class);
    }
}
