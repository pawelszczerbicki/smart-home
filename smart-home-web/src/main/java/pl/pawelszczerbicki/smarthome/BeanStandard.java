package pl.pawelszczerbicki.smarthome;

import org.springframework.stereotype.Service;

/**
 * Created by Pawel on 04.12.13.
 */
@Service
public class BeanStandard {

    private int test = 0;

    public int getTest() {
        return test;
    }

    public void add(){
        test++;
    }
}
