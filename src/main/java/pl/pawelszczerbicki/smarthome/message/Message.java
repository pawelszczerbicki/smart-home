package pl.pawelszczerbicki.smarthome.message;

import lombok.Getter;
import lombok.Setter;
import pl.pawelszczerbicki.smarthome.device.Device;
import pl.pawelszczerbicki.smarthome.device.DeviceAction;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.09.13
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@XmlRootElement
public class Message {
    private MessageType type;
    private Device device;
    private DeviceAction action;
    private Integer value;

    public Message(MessageType type) {
        this.type = type;
    }

    public Message() {
    }
}

