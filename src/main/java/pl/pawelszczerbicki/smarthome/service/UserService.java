package pl.pawelszczerbicki.smarthome.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 07.08.13
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
