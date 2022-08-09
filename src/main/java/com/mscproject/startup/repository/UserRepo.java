package com.mscproject.startup.repository;

import com.mscproject.startup.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Defines a repository which provides an API or a list of helpful functions
// that helps us to work with the User entity
public interface UserRepo extends JpaRepository<AppUser, Long> {
    // Defines a custom method to find a User using the email attribute
    public Optional<AppUser> findByEmail(String email);
}
