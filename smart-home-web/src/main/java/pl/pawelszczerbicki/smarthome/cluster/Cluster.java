package pl.pawelszczerbicki.smarthome.cluster;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 08.10.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Document(collection = "clusters")
public class Cluster {

    private String id;

    private String name;

    private String active;

}
