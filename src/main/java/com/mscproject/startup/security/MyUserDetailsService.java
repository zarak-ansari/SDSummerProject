package com.mscproject.startup.security;

import com.mscproject.startup.model.AppUser;
import com.mscproject.startup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

// A UserDetailsService is used to fetch the user details of the user trying to authenticate
// into the application. This is done in the loadUserByUsername method.
// If no such user is found a UsernameNotFoundException is thrown

@Component // Marks this as a component. Now, Spring Boot will handle the creation and
           // management of the MyUserDetailsService Bean
// and you will be able to inject it in other places of your code
public class MyUserDetailsService implements UserDetailsService {

    // Injecting Dependencies
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch User from the DB
        Optional<AppUser> userRes = userRepo.findByEmail(email);
        // No user found
        if (userRes.isEmpty())
            throw new UsernameNotFoundException("Could not findUser with email = " + email);
        // Return a User Details object using the fetched User information
        AppUser user = userRes.get();
        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))); // Sets the role of the found user
    }
}
