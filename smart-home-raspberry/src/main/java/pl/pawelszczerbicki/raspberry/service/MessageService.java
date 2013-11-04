package pl.pawelszczerbicki.raspberry.service;

import pl.pawelszczerbicki.raspberry.model.Action;
import pl.pawelszczerbicki.raspberry.model.Message;
import pl.pawelszczerbicki.raspberry.model.MessageType;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 02.11.13
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
public class MessageService {

    private final static MessageService messageService = new MessageService();

   // private RaspberryService raspberryService = RaspberryService.getInstance();

    public static MessageService getInstance() {
        return messageService;
    }

    private MessageService() {
    }

    public void serviceMessage(Message m) {
        if (m.getType() == MessageType.ACTION) {
            serviceAction(m);
        }
    }

    private void serviceAction(Message m) {
        if (m.getAction() == Action.ON) {
            System.out.println("Setting state hight");
            //raspberryService.setPinState(m.getRaspiPin(), true);
        } else if (m.getAction() == Action.OFF) {
            System.out.println("Setting state low");
           // raspberryService.setPinState(m.getRaspiPin(), false);
        } else if(m.getAction() == Action.FLICKER){
            System.out.println("Flickering");
           // raspberryService.flicker(m.getRaspiPin(), getFlickerTime(m.getMessage()));
        } else if(m.getAction() == Action.ADJUST){
           // raspberryService.flicker(m.getRaspiPin(), getFlickerTime(m.getMessage()));
            System.out.println("Adjusting, setting value: " +  m.getMessage());
        }
    }

    private Integer getFlickerTime(String m) {
          try{
              return Integer.parseInt(m);
          } catch (NumberFormatException e){
              return 500;
          }
    }
}
