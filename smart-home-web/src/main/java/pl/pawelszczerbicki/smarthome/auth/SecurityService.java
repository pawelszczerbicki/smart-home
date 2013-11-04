package pl.pawelszczerbicki.smarthome.auth;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static org.apache.log4j.Logger.getLogger;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 07.08.13
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SecurityService implements UserDetailsService {

    private final Logger logger = getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("User is logging in " + s);
        if (StringUtils.isBlank(s)) throw new UsernameNotFoundException("User not found: " + s);
        User user = userDao.getByUsernameOrEmail(s);
        if (user == null) throw new UsernameNotFoundException("User not found: " + s);
        return user;
    }

    public User getUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        if(context != null){
            Authentication auth = context.getAuthentication();
            if(auth !=  null && auth.isAuthenticated() && auth.getPrincipal() != null && auth.getPrincipal() instanceof User)
                return (User) auth.getPrincipal();
        }
        return null;
    }
}
