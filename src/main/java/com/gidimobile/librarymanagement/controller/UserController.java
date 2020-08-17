package com.gidimobile.librarymanagement.controller;

import com.gidimobile.librarymanagement.models.ApplicationUser;
import com.gidimobile.librarymanagement.services.serviceImpl.ApplicationUserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private ApplicationUserDetailsService userService;

    public UserController(ApplicationUserDetailsService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ApplicationUser signUp(@RequestBody ApplicationUser user){
       return userService.registerUser(user);

    }

}
