package com.webproject.newsblog.controllers;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.services.CommentService;
import com.webproject.newsblog.services.PostService;
import com.webproject.newsblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class  HomeController {

  private final PostService postService;
  private final UserService userService;
  private final CommentService commentService;

  @Autowired
  public HomeController(PostService postService, CommentService commentService, UserService userService) {

    this.postService = postService;
    this.userService = userService;
    this.commentService = commentService;
  }
  
  @GetMapping("/single_post")
  public String home() {
	 // throw new RuntimeException("Test Exception");
    return "single_post";
  }

  @GetMapping("/test/{id}")
  public String test(@PathVariable long id, Model model, Comment comment){
    Post post = postService.findById(id);
    post.setViews(post.getViews()+1);
    postService.update(post);
    List<Comment> comments  = commentService.findPostCommentByDate(post);
    model.addAttribute("post", post);
    model.addAttribute("comments", comments);
    if (commentService.countByPost(post) == 0){
      model.addAttribute("noc", "There aren't any comments yet");
    }else if (commentService.countByPost(post) >5) {
      model.addAttribute("noc", "Showing 5 comments of " + commentService.countByPost(post) );
    }else {
      model.addAttribute("noc", commentService.countByPost(post) + " Comments");
    }

    return "staff/test";
  }


    @GetMapping("/first")
    public String first(){
        return "first";
    }

  @GetMapping("/testsec")
  public String testSec() {
    return "testsec";    
  }

}
