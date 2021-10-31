package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Rating;
import com.webproject.newsblog.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> findRatingByPost(Post post) {
        return ratingRepository.findByPost(post);
    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public float calculateAverageRating(Post post) {
        List<Rating> ratings = ratingRepository.findByPost(post);
        int totalRatings = ratingRepository.countByPost(post);
        float average = 0;
        float sum = 0;
        for (Rating rating :
                ratings) {
            sum += (float) rating.getRatingValue();
        }
        average = sum / totalRatings ;

        return average;
    }

    @Override
    public int countByPost(Post post) {
        return ratingRepository.countByPost(post);
    }


}
