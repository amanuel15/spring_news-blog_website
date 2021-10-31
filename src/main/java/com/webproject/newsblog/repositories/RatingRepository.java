package com.webproject.newsblog.repositories;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.domains.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    List<Rating> findByPost(Post post);
    int countByPost(Post post);
}
