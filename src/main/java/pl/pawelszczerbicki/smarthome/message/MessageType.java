package pl.pawelszczerbicki.smarthome.message;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 12.10.13
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public enum MessageType {
    //WELCOME - welcome on start device
    //CONFIG - config device
    //ACTION - perform action
    //CHECK - check raspberry
    //INFO - info about state etc
    WELCOME, CONFIG, ACTION, CHECK_DEVICE, INFO, HEARTBEAT, NOTIFICATION
}
