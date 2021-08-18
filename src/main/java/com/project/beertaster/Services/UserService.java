package com.project.beertaster.Services;

import com.project.beertaster.Configs.MyUserDetailsService;
import com.project.beertaster.Entities.User;
import com.project.beertaster.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public User findCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username);
    }

    public User registerUser(User user){
        return myUserDetailsService.addUser(user.getUsername(), user.getPassword());
    }
}
