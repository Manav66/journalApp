package net.learningproj.journalApp.controller;

import lombok.extern.slf4j.Slf4j;
import net.learningproj.journalApp.entity.User;
import net.learningproj.journalApp.service.UserDetailsServiceImpl;
import net.learningproj.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Slf4j

public class PublicController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }
}
