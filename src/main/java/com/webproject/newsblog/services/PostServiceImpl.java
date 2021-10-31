package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.repositories.PostRepository;
import com.webproject.newsblog.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public void addPost(Post post) {
        post.setDateCreated(new Date());
        postRepository.save(post);
    }

    public void deletePost(Post post) {postRepository.delete(post);}
    public Post findByTitle(String title){return postRepository.findByTitle(title);}

    @Override
    public void update(Post post) {
        postRepository.save(post);
    }

    public List<Post> findAllPosts(){return (List<Post>) postRepository.findAll();}
    public List<Post> postByCreator(User creator) {return  postRepository.findByCreator(creator);}

    @Override
    public Post findById(long id) {
        return postRepository.findById(id);
    }

}
