package pl.pawelszczerbicki.smarthome;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * Created by Pawel on 04.12.13.
 */
@Service
@Scope(value = "globalSession", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GlobalSession {

    private int test = 0;

    public int getTest() {
        return test;
    }

    public void add(){
        test++;
    }
}
