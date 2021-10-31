package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Review;
import com.webproject.newsblog.repositories.ReviewRepository;
import com.webproject.newsblog.security.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findReviewByPost(Post post) {
        return reviewRepository.findByReviewedPost(post);
    }

    @Override
    public List<Review> findReviewByReviewer(User user) {
        return reviewRepository.findByReviewer(user);
    }



    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findAReview(Long id) {
        return reviewRepository.findById(id).isPresent() ? reviewRepository.findById(id).get() : null;
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.delete(review);
    }
}
