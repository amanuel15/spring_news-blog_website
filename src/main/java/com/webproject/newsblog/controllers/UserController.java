package com.webproject.newsblog.controllers;

import com.webproject.newsblog.security.User;
import com.webproject.newsblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute(name="user")
    public User tacoDesign() {
        return new User();
    }
//    @ModelAttribute(name="user")
//    public UserDetails user(@AuthenticationPrincipal UserDetails userDetails) {
//        String username = userDetails.getUsername();
//        User user = userService.findUserByUsername(username);
//        return user;
//    }

    @GetMapping
    public List<User> allUsers(){
        return userService.findAll();
    }

}
