package com.webproject.newsblog.controllers;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Rating;
import com.webproject.newsblog.security.User;
import com.webproject.newsblog.services.PostService;
import com.webproject.newsblog.services.RatingService;
import com.webproject.newsblog.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RatingController {

    private final RatingService ratingService;
    private final UserService userService;
    private final PostService postService;

    public RatingController(RatingService ratingService, UserService userService, PostService postService) {
        this.ratingService = ratingService;
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("/rating/{id}")
    public String rate(@Valid Rating rating, @PathVariable Long id, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails){
        if (bindingResult.hasErrors()){
            return "review";
        }
        User rater = userService.findUserByUsername(userDetails.getUsername());
        Post post = postService.findById(id);
        rating.setRater(rater);
        rating.setPost(post);
        ratingService.addRating(rating);
        return "redirect:/review/" + id;
    }



}
