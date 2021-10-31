package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.security.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface PostService {

    void addPost(Post post);

    void deletePost(Post post );
    List<Post> findAllPosts();
    List<Post> postByCreator(User creator);

    Post findById(long id);
    Post findByTitle(String title);

    void update(Post post);

//    long getGeneratedKey(String name, Date rescued, Boolean vaccinated);

}
