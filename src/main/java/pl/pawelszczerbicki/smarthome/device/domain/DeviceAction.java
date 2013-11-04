package pl.pawelszczerbicki.smarthome.device.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public enum DeviceAction {
    SWITCH, FLICKER, ADJUST, READ

}
