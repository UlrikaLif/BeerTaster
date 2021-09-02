package com.project.beertaster.Controllers;

import com.project.beertaster.Entities.User;
import com.project.beertaster.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/auth/register")
    public User register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/auth/login")
    public User loginUser(@RequestBody User user, HttpServletRequest req){
        return userService.customLogin(user, req);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/auth/current-user")
    public User findCurrentUser(){
        return userService.findCurrentUser();
    }

}
