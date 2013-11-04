package pl.pawelszczerbicki.smarthome.auth;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.pawelszczerbicki.smarthome.account.Account;
import pl.pawelszczerbicki.smarthome.email.Email;
import pl.pawelszczerbicki.smarthome.email.EmailService;
import pl.pawelszczerbicki.smarthome.utils.StringTools;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 28.09.13
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    private static final Integer PASSWORD_SIZE = 10;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserDao userDao;

    @Value("${user.send.account.id.subject}")
    private String apiKeySubject;

    @Value("${user.send.account.id.content}")
    private String apiKeyContent;

    @Autowired
    private StringTools stringTools;

    public void save(UserDto u, Account a){
        save(new User(DigestUtils.md5Hex(u.getPassword()), u.getEmail(), a));
    }

    public void save(User user) {
        emailService.send(new Email(user.getEmail(), apiKeySubject, apiKeyContent + user.getAccount().getId()));
        userDao.save(user);
    }

    public boolean userExists(String email) {
        return userDao.getByUsernameOrEmail(email) != null;
    }

    public User get(String email) {
        return userDao.getByUsernameOrEmail(email);
    }

    public void changePassword(User user) {
        String pwd = RandomStringUtils.randomAlphanumeric(PASSWORD_SIZE);
        emailService.send(new Email(user.getEmail(),StringTools.RESET_PASSWORD_SUBJECT, stringTools.formatContent(pwd)));
        user.setPassword(DigestUtils.md5Hex(pwd));
        userDao.save(user);
    }
}
