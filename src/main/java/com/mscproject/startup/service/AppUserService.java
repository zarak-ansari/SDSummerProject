package com.mscproject.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mscproject.startup.model.AppUser;
import com.mscproject.startup.repository.UserRepo;

@Service
public class AppUserService {

    @Autowired
    private UserRepo userRepository;

    public String getUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public AppUser getUser() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(email).get();

    }

}
