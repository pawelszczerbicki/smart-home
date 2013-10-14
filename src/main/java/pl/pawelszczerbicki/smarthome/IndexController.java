package pl.pawelszczerbicki.smarthome;

import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 26.09.13
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
	public String main() {
        return "index";
	}

    @RequestMapping(value = "/test")
	public String test() {
        Broadcaster broadcaster = BroadcasterFactory.getDefault().lookup("aa");
        broadcaster.broadcast("aa");
        return "index";
	}

    @RequestMapping(value = "/dashboard")
	public String dashboard() {
        return "dashboard";
	}
}