package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    List<Rating> findRatingByPost(Post post);
    void addRating(Rating rating);
    float calculateAverageRating(Post post);
    int countByPost(Post post);


}
