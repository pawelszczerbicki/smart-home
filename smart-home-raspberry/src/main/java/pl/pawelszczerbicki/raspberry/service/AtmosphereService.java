package pl.pawelszczerbicki.raspberry.service;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.atmosphere.wasync.*;
import pl.pawelszczerbicki.raspberry.model.Message;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.10.13
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class AtmosphereService {

    static Logger logger = Logger.getLogger(AtmosphereService.class);
    private static String LOCAL_ADDRESS = "http://localhost:8080/rest/message/device";

    private static String REMOTE_ADDRESS = "http://pawelszczerbicki.pl:8080/smart-home/chat/5249cbba2fd4972c7c078edf";

    private Socket socket;

    private MessageService messageService = MessageService.getInstance();

    public AtmosphereService() {
        final Gson gson = new Gson();
        Client client = ClientFactory.getDefault().newClient();
        RequestBuilder request = getTransport(gson, client);
        socket = client.create();
        logger.info("Socket created with state: " + socket.status());
        try {
            overrideMethodsAndOpenSocket(request);
        } catch (IOException e) {
            logger.error("Could not initialize socket.", e);
        }
    }

    public void send(Message m) {
        if (socket == null) throw new IllegalStateException("Socket is not initialized!");
        try {
            socket.fire(m);
        } catch (IOException e) {
            logger.error("Could not fire socket and send message", e);
        }
    }

    private void overrideMethodsAndOpenSocket(RequestBuilder request) throws IOException {
        socket.on(new Function<Message>() {
            @Override
            public void on(Message m) {
               logger.info("message: " + m.getType());                   ;
               messageService.serviceMessage(m);
            }
        }).on(new Function<IOException>() {

            @Override
            public void on(IOException e) {
                logger.error("Socket exception ", e);
            }
        }).open(request.build());
    }

    private RequestBuilder getTransport(final Gson gson, Client client) {
        return client.newRequestBuilder()
                .method(Request.METHOD.GET)
                .uri(LOCAL_ADDRESS)
                .header("Content-Type", "application/json")
                .encoder(new Encoder<Message, String>() {
                    @Override
                    public String encode(Message m) {
                        return gson.toJson(m);
                    }
                })
                .decoder(new Decoder<String, Message>() {
                    @Override
                    public Message decode(Event e, String s) {
                        return gson.fromJson(s.split("\\|")[1], Message.class);
                    }
                })
                .transport(Request.TRANSPORT.WEBSOCKET)
                .transport(Request.TRANSPORT.LONG_POLLING);
    }
}
