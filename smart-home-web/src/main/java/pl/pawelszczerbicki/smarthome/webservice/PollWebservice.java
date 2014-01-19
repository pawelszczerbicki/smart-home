package pl.pawelszczerbicki.smarthome.webservice;

import org.apache.log4j.Logger;
import org.atmosphere.annotation.Suspend;
import org.atmosphere.config.service.AtmosphereService;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.jersey.JerseyBroadcaster;
import pl.pawelszczerbicki.smarthome.message.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

import static org.apache.log4j.Logger.getLogger;


/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.09.13
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */

@Path("/")
@AtmosphereService(broadcaster = JerseyBroadcaster.class)
public class PollWebservice {

    private final Logger logger = getLogger(getClass());

    @Suspend
    @GET
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String suspend(@Context AtmosphereResource atmosphereResource, @PathParam("accountId") String accountId) {
        Broadcaster privateChannel = BroadcasterFactory.getDefault().lookup(accountId, true);
        atmosphereResource.suspend(12, TimeUnit.MINUTES);
        privateChannel.addAtmosphereResource(atmosphereResource);
        logger.info("Socket opened for: "+accountId);
        return "";
    }

    @POST
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    //TODO check if raspberry exists
    //TODO synchronize all devices
    public void broadcast(Message m, @PathParam("accountId") String accountId) {
        logger.info("Send message by : " + accountId);
        Broadcaster broadcaster = BroadcasterFactory.getDefault().lookup(accountId);
        broadcaster.broadcast(m);
    }
}
