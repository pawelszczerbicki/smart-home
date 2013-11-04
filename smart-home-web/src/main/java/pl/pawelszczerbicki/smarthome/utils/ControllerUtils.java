package pl.pawelszczerbicki.smarthome.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import com.google.common.base.Function;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.transform;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 29.09.13
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ControllerUtils {

    public Collection<String> transformErrorsToCode(List<ObjectError> allErrors) {
        return transform(allErrors, toCode());
    }

    private Function<ObjectError, String> toCode() {
        return new Function<ObjectError, String>() {
            @Override
            public String apply(ObjectError input) {
                return input.getDefaultMessage();
            }
        };

    }
}
