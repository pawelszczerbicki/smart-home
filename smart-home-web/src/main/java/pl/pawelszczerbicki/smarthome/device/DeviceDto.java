package pl.pawelszczerbicki.smarthome.device;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pawelszczerbicki.smarthome.device.domain.DeviceAction;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 01.11.13
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@ToString
public class DeviceDto {

    private String name;

    private Integer pin;

    private DeviceAction action;

}
