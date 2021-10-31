package com.webproject.newsblog.controllers;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.security.User;
import com.webproject.newsblog.services.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public PostController(PostService postService, CommentService commentService, UserService userService, RoleService roleService) {

        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
        this.roleService = roleService;
    }

    @GetMapping("/posts")
    public String postHome( Model model, @AuthenticationPrincipal UserDetails userDetails){
        List<Post> allPosts = postService.findAllPosts();
        User user = userService.findUserByUsername(userDetails.getUsername());
        List<Post> postsByCreator = postService.postByCreator(user);
        model.addAttribute("posts", allPosts);
        String role =  roleService.findRole(userService.findUserByUsername(userDetails.getUsername()));

        if (role.equals("[Role(id=1, role=USER)]")){
            return "user/index";

        }else if (role.equals("[Role(id=2, role=STAFF)]")){

            if (postsByCreator != null)
                model.addAttribute("posts", postsByCreator);
            else
                model.addAttribute("message", "Your posts will appear here after you upload a story.");

            return "staff/manage_post";

        }
        return null;

    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postService.findAllPosts());
        return "index";
    }

    @GetMapping("/post/{id}")
    public String singlePost(@PathVariable long id, Model model, Comment comment){
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
            model.addAttribute("moreComment", "Get more comment");
        }else {
            model.addAttribute("noc", commentService.countByPost(post) + " Comments");
        }

        return "user/single_post";
    }
    @GetMapping("/spu/{id}")
    public String spu(@PathVariable long id, Model model){
        Post post = postService.findById(id);
        post.setViews(post.getViews()+1);
        postService.update(post);
        List<Comment> comment = commentService.findPostCommentByDate(post);
        model.addAttribute("post", post);
        model.addAttribute("comments", comment);
        if (commentService.countByPost(post) == 0){
            model.addAttribute("noc", "There aren't any comments yet");
        }else if (commentService.countByPost(post) >5) {
            model.addAttribute("noc", "Showing 5 comment of " + commentService.countByPost(post) );
            model.addAttribute("moreComment", "Get more comment");

        }else {
            model.addAttribute("noc", commentService.countByPost(post) + " Comments");
        }
        return "single_postU";
    }


    @GetMapping("/postStory")
    public String postStory( Post post){return "staff/post_story";}

    @GetMapping("/postByCreator/{username}")
    public String PBC(Model model, @PathVariable String username){

        User postCreator =  userService.findUserByUsername(username);

        model.addAttribute("postsByCreator", postService.postByCreator(postCreator));
        return "postsByCreator";
    }

    @GetMapping("/pbc/{username}")
    public String pbcu(Model model, @PathVariable String username){

        User postCreator =  userService.findUserByUsername(username);

        model.addAttribute("postsByCreator", postService.postByCreator(postCreator));
        return "pbcu";
    }
    @GetMapping("/managePosts")
    public String managePost(@AuthenticationPrincipal UserDetails userDetails, Model model){
        User user = userService.findUserByUsername(userDetails.getUsername());
        if (postService.postByCreator(user) != null)
            model.addAttribute("posts", postService.postByCreator(user));
        else
            model.addAttribute("message", "Your posts will appear here after you upload a story.");
            

        return "staff/manage_post";
    }

    @GetMapping(value = "/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        Post post = postService.findById(id);
        postService.deletePost(post);
        System.out.println("A post by the id of " + id+ "was removed from our database.  ");
        return "redirect:/managePosts";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, Post post){
        Post post1= postService.findById(id);
        model.addAttribute("post", post1);

        return "staff/edit_post";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@Valid Post post, @AuthenticationPrincipal UserDetails userDetails, @PathVariable Long id){

        Post post1 = postService.findById(id);
        post1.setTitle(post.getTitle());
        post1.setBody(post.getBody());
        postService.addPost(post1);
        return "redirect:/managePosts";
    }

    @PostMapping("/addPost")
    public String addPost(@Valid  Post post, @AuthenticationPrincipal UserDetails userDetails, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            System.out.println(model.asMap());
            return "post_story";
        }
        User user = userService.findUserByUsername(userDetails.getUsername());
        post.setCreator(user);
        postService.addPost(post);
        System.out.println(model.asMap());
        model.addAttribute("successMessage", "you have successfully posted a new post.");
        return "redirect:/postStory";
    }
}
