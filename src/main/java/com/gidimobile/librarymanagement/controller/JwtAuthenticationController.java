package com.gidimobile.librarymanagement.controller;

import com.gidimobile.librarymanagement.models.JwtRequest;
import com.gidimobile.librarymanagement.models.JwtResponse;
import com.gidimobile.librarymanagement.services.serviceImpl.ApplicationUserDetailsService;
import com.gidimobile.librarymanagement.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        return userDetailsService.createAuthenticationToken(authenticationRequest);
    }

}
