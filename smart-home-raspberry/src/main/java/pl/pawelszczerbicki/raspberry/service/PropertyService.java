package pl.pawelszczerbicki.raspberry.service;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 12.10.13
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
public class PropertyService {

    static Logger logger = Logger.getLogger(PropertyService.class);

    private Properties prop = new Properties();

    private static final String PROPERTIES_FILE = "./smart-home.config";

    public String getPropety(String property) {
        try {
            prop.load(new FileInputStream(PROPERTIES_FILE));
            return prop.getProperty(property);
        } catch (IOException e) {
            logger.error("Error loading property file", e);
            return null;
        }
    }
}
