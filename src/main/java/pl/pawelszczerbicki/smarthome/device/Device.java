package pl.pawelszczerbicki.smarthome.device;

import com.pi4j.io.gpio.RaspiPin;
import lombok.Getter;
import lombok.Setter;
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
@Document(collection = "devices")
@XmlRootElement
public class Device {

    private String id;

    private String name;

    private Set<DeviceAction> actions;

    private DeviceState deviceState;

    private Integer value;

    private RaspiPin raspiPin;

    private Boolean active;

    public Device() {
        actions = new HashSet<>();
    }

    public void addAction(DeviceAction deviceAction){
           actions.add(deviceAction);
    }

    public boolean hasAction(DeviceAction deviceAction){
           return actions.contains(deviceAction);
    }
}
