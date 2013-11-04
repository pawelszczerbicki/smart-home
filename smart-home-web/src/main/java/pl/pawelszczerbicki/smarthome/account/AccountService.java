package pl.pawelszczerbicki.smarthome.account;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawelszczerbicki.smarthome.auth.UserDao;
import pl.pawelszczerbicki.smarthome.auth.User;
import pl.pawelszczerbicki.smarthome.auth.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 29.09.13
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private UserService userService;

    public Account getByDomain(String d){
        return  accountDao.getByDomain(d);
    }

    public void saveWithUser(AccountDto account) {
        Account a = new Account(account.getDomain());
        accountDao.save(a);
        userService.save(new User(DigestUtils.md5Hex(account.getPassword()), account.getEmail(), a));
    }

    public boolean accountExists(String d) {
        return getByDomain(d) != null;

    }
}
