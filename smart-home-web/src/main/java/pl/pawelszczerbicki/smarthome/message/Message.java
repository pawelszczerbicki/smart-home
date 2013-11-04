package pl.pawelszczerbicki.smarthome.message;

import lombok.Getter;
import lombok.Setter;

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
    private String deviceId;
    private Integer raspiPin;
    private Action action;
    private String message;

    public Message(MessageType type) {
        this.type = type;
    }

    public Message() {
    }
}

