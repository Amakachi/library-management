package com.gidimobile.librarymanagement.security;

import com.gidimobile.librarymanagement.models.ApplicationUser;
import com.gidimobile.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoggedInUser {
    @Autowired
    static UserRepository userRepository;


    private LoggedInUser() {
    }

    public ApplicationUser getCurrentUser() {



        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {

            UserDetails userDetails = (UserDetails)principal;
            ApplicationUser applicationUser = userRepository.findByUsername(userDetails.getUsername());
            return applicationUser;
        }
        throw new InsufficientAuthenticationException("Invalid authentication credentials. Invalid user access token");


    }

}