package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Review;
import com.webproject.newsblog.security.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    List<Review> findReviewByPost(Post post);
    List<Review> findReviewByReviewer(User user);
    List<Review> findAllReviews();

    Review findAReview(Long id);

    void addReview(Review review);
    void deleteReview(Review review);
}
