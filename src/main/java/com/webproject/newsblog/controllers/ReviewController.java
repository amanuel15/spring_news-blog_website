package com.webproject.newsblog.controllers;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Rating;
import com.webproject.newsblog.domains.Review;
import com.webproject.newsblog.security.User;
import com.webproject.newsblog.services.PostService;
import com.webproject.newsblog.services.RatingService;
import com.webproject.newsblog.services.ReviewService;
import com.webproject.newsblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final PostService postService;
    private final UserService userService;
    private final RatingService ratingService;

    @Autowired
    public ReviewController(ReviewService reviewService, PostService postService, UserService userService, RatingService ratingService) {
        this.reviewService = reviewService;
        this.postService = postService;
        this.userService = userService;
        this.ratingService = ratingService;
    }

    @GetMapping("/review/{id}")
    public String getReview(Review review, @PathVariable Long id, Model model, Rating rating){
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("reviews", reviewService.findReviewByPost(post));
        float aur = ratingService.calculateAverageRating(post);
        model.addAttribute("ratingStatus", String.format("%.01f", aur) + " average based on " + ratingService.countByPost(post) +" reviews.");
        post.setAverageRating(aur);
        postService.addPost(post);
        return "review";
    }

    @PostMapping("/reviewPost/{id}")
    public String reviewPost(@ModelAttribute(name = "review") @Valid Review review, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "review";
        }
        Post post = postService.findById(id);
        User reviewer = userService.findUserByUsername(userDetails.getUsername());
        review.setReviewer(reviewer);
        review.setReviewedPost(post);
        reviewService.addReview(review);

        return "redirect:/review/" + id;



    }
}
