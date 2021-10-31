package com.webproject.newsblog.repositories;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Review;
import com.webproject.newsblog.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAll();
    List<Review> findByReviewedPost(Post post);
    List<Review> findByReviewer(User reviewer);

}
