package pl.pawelszczerbicki.raspberry.main;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.apache.log4j.Logger;
import pl.pawelszczerbicki.raspberry.model.Message;
import pl.pawelszczerbicki.raspberry.model.MessageType;
import pl.pawelszczerbicki.raspberry.service.AtmosphereService;

public class Main implements Runnable{
    static Logger logger = Logger.getLogger(Main.class);
    private static AtmosphereService atmosphereService =  new AtmosphereService();

    public static void main(String[] args) throws InterruptedException {
        logger.info("started");
        //(new Thread(new Main())).start();
        (new Thread(new ValuesSender())).start();
        atmosphereService.send(new Message(MessageType.WELCOME));

    }


    @Override
    public void run() {
        logger.info("<--Pi4J--> GPIO Listen Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN);
        final GpioPinDigitalInput myButton2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07, PinPullResistance.PULL_DOWN);

        // create and register gpio pin listener
        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                atmosphereService.send(new Message(MessageType.ACTION));

                logger.info(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
            }

        });
        myButton2.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                atmosphereService.send(new Message());
                logger.info(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
            }

        });

        logger.info(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");

        // keep program running until user aborts (CTRL-C)
        for (;;) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
