package pl.pawelszczerbicki.smarthome.webservice;

import org.apache.log4j.Logger;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.pawelszczerbicki.smarthome.account.AccountService;
import pl.pawelszczerbicki.smarthome.message.Message;
import pl.pawelszczerbicki.smarthome.message.MessageType;

import static org.apache.log4j.Logger.getLogger;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 13.10.13
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */

@Service
public class BroadcasterService {

    private final Logger logger = getLogger(getClass());

    @Autowired
    private AccountService accountService;

    @Scheduled(cron = "0 0/5 * * * *")
    public void heartBeat(){
        Broadcaster b = BroadcasterFactory.getDefault().lookup("/*");
            logger.info(b.getID());
            b.broadcast(new Message(MessageType.HEARTBEAT));
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void checkRaspberry(){
        accountService.

    }

}
