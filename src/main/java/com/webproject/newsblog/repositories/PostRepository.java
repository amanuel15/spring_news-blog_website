package com.webproject.newsblog.repositories;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.security.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {

    List<Post> findByCreator(User creator);
    Post findByTitle(String title);
    Post findById(long id);

}
