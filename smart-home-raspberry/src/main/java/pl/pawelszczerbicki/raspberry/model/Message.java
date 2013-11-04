package pl.pawelszczerbicki.raspberry.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.09.13
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class Message {
    private MessageType type;
    private String deviceId;
    private Integer raspiPin;
    private Action action;
    private String message;
    public Message() {
    }

    public Message(MessageType mt) {
        this.type = mt;
    }
}
