package com.webproject.newsblog.controllers;


import com.webproject.newsblog.security.User;
import com.webproject.newsblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {
	
	private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute(name="user")
	public User user() {
		return new User();
	}

    @GetMapping("/login")
    public String login(){
        return "signin";
    }


    @GetMapping("/registration")
    public String registration(){
        return "signup";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid User user,BindingResult bindingResult, Model model, @RequestParam("role") String role) {
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("user", "error.user",
                            "There is already a user registered with the username provided");
        }


        if (bindingResult.hasErrors()) {
            return "signin";
        } else {
            userService.saveUser(user, role);

            model.addAttribute("successMessage", "User has been registered successfully");

            return "signin";
        }
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied";
    }

}
