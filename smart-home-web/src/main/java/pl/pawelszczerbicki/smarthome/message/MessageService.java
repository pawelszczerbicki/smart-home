package pl.pawelszczerbicki.smarthome.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawelszczerbicki.smarthome.account.Account;
import pl.pawelszczerbicki.smarthome.account.AccountService;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 14.11.13
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageService {

    @Autowired
    private AccountService accountService;

    public void service(Message m, String accountId) {
        if (m.getType() == MessageType.CHECK_DEVICE) {
            serviceCheckDedice(m, accountId);
        }
    }

    private void serviceCheckDedice(Message m, String accountId) {
        Account a = accountService.get(accountId);
        a.setDeviceUpdatedAt(new Date());
        accountService.save(a);

    }
}
