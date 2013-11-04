package pl.pawelszczerbicki.raspberry.main;

import pl.pawelszczerbicki.raspberry.model.Action;
import pl.pawelszczerbicki.raspberry.model.Message;
import pl.pawelszczerbicki.raspberry.model.MessageType;
import pl.pawelszczerbicki.raspberry.service.AtmosphereService;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 02.11.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class ValuesSender implements Runnable {

    private AtmosphereService atm = new AtmosphereService();

    @Override
    public void run() {
        while (true) {
            Message m = new Message();
            m.setType(MessageType.ACTION);
            m.setMessage(new Integer(new Random().nextInt(20)).toString());
            m.setRaspiPin(6);
            m.setAction(Action.READ);
            atm.send(m);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
