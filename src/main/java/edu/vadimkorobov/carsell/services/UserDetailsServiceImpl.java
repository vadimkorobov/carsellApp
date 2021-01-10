package edu.vadimkorobov.carsell.services;

import edu.vadimkorobov.carsell.entity.User;
import edu.vadimkorobov.carsell.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User appUser = userRepository.findByLogin(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);


        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(appUser.getLogin(), //
                appUser.getPassword(), mapRolesToAuthorities());

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities() {

        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

}