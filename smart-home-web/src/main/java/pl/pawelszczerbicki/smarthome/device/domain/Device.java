package pl.pawelszczerbicki.smarthome.device.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
@Document(collection = "devices")
@XmlRootElement
public class Device {

    private String id;

    private String accountId;

    private String name;

    private Set<DeviceAction> actions;

    private DeviceState deviceState;

    private Integer value;

    private Integer raspiPin;

    private Boolean active = true;

    public Device() {
        actions = new HashSet<>();
    }

    public Device(String name, DeviceAction deviceAction, Integer raspiPin, String accountId) {
        this();
        this.name = name;
        addAction(deviceAction);
        this.raspiPin = raspiPin;
        this.accountId = accountId;
        this.deviceState = DeviceState.OFF;
    }

    public void addAction(DeviceAction deviceAction) {
        actions.add(deviceAction);
    }

    public boolean hasAction(DeviceAction deviceAction) {
        return actions.contains(deviceAction);
    }


}
