package pl.pawelszczerbicki.raspberry.service;

import com.pi4j.io.gpio.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 11.10.13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class RaspberryService {

    private final static RaspberryService service = new RaspberryService();

    private final static GpioController gpio = GpioFactory.getInstance();

    private static Map<Integer, GpioPinDigitalOutput> pinMap = new HashMap<>();
    public static RaspberryService getInstance() {
        return service;
    }
    static {
        pinMap.put(0, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00));
        pinMap.put(1, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01));
        pinMap.put(2, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02));
        pinMap.put(3, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03));
        pinMap.put(4, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04));
        pinMap.put(5, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05));
        pinMap.put(6, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06));
        pinMap.put(7, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07));
        pinMap.put(8, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08));
        pinMap.put(9, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09));
        pinMap.put(10, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10));
        pinMap.put(11, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11));
        pinMap.put(12, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12));
        pinMap.put(13, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13));
        pinMap.put(14, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14));
        pinMap.put(15, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15));
        pinMap.put(16, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16));
        pinMap.put(17, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17));
        pinMap.put(18, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18));
        pinMap.put(19, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19));
        pinMap.put(20, gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20));
    }

    private RaspberryService() {
    }

    public void setPinState(Integer p, boolean state) {
        pinMap.get(p).setState(state);
    }

    public void flicker(Integer p, Integer t) {
        pinMap.get(p).pulse(t, false);
    }
}
