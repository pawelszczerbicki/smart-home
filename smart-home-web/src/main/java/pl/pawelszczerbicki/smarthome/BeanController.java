package pl.pawelszczerbicki.smarthome;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.apache.log4j.Logger.getLogger;

/**
 * Created by Pawel on 04.12.13.
 */
@Controller
public class BeanController {
    private final Logger logger = getLogger(getClass());

    @Autowired
    private BeanPrototype beanPrototype;

    @Autowired
    private BeanRequest request;

    @Autowired
    private BeanSession beanSession;

    @Autowired
    private BeanStandard standard;

    @Autowired
    private GlobalSession globalSession;

    @RequestMapping(value = "/beans")
    @ResponseBody
    public String testBean(){
        logger.info("proto before:" + beanPrototype.getTest());
        logger.info("request before:" + request.getTest());
        logger.info("session before:" + beanSession.getTest());
        logger.info("stand before:" + standard.getTest());
        logger.info("global before:" + globalSession.getTest());
        
        beanPrototype.add();
        request.add();
        beanSession.add();
        standard.add();
        globalSession.add();

        logger.info("proto after:" + beanPrototype.getTest());
        logger.info("request after:" + request.getTest());
        logger.info("session after:" + beanSession.getTest());
        logger.info("stand after:" + standard.getTest());
        logger.info("global after:" + globalSession.getTest());
        
        return "ok";
    }

}
