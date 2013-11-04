package pl.pawelszczerbicki.smarthome.auth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 28.09.13
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "roles")
public class Role {

    private String id;

    private RoleName name;
}
