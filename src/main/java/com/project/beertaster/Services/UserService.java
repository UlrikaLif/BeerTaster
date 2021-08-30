package com.project.beertaster.Services;

import com.project.beertaster.Configs.MyUserDetailsService;
import com.project.beertaster.Entities.User;
import com.project.beertaster.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    // bean from your SecurityConfig
    @Resource(name = "authenticationManager")
    private AuthenticationManager authManager;

    public User findCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username);
    }

    public User registerUser(User user){
        return myUserDetailsService.addUser(user);
    }


    public User customLogin(User user, HttpServletRequest req) {
       try{
           UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
           Authentication auth = authManager.authenticate(authReq);

           SecurityContext sc = SecurityContextHolder.getContext();
           sc.setAuthentication(auth);
           HttpSession session = req.getSession(true);
           session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
       } catch (BadCredentialsException err){
           throw new BadCredentialsException("Bad Credentials");
       }
       return findCurrentUser();
    }
}
