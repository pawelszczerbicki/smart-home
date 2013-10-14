package pl.pawelszczerbicki.smarthome.contact;

import org.springframework.stereotype.Repository;
import pl.pawelszczerbicki.smarthome.commons.GenericDao;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ContactDao extends GenericDao<Contact> {

    public ContactDao() {
        super(Contact.class);
    }
}
