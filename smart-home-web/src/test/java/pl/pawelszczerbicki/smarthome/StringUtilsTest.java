package pl.pawelszczerbicki.smarthome;

import org.junit.Test;
import pl.pawelszczerbicki.smarthome.utils.StringTools;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 11.11.13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class StringUtilsTest {

     private StringTools stringTools = new StringTools();

    @Test
    public void checkIfEmailIsValidatedCorrectly(){
        String email ="sample@sample.com";
        System.out.println(stringTools.validEmail(email));
    }
}
