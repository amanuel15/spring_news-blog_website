package com.webproject.newsblog.controllers;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.security.User;
import com.webproject.newsblog.services.CommentService;
import com.webproject.newsblog.services.PostService;
import com.webproject.newsblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CommentController {


    private final CommentService commentService;
    private final UserService userService;
    private final PostService postService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService, PostService postService) {
        this.commentService = commentService;
        this.userService = userService;
        this.postService = postService;
    }
//
//    @ModelAttribute( name = "comment")
//    public Comment comment(){return  new Comment();}

    @PostMapping("/comment")
    public String makeAComment(@AuthenticationPrincipal UserDetails userDetails,@Valid Comment comment, BindingResult bindingResult, @RequestParam Long id, Model model){
        if (bindingResult.hasErrors()){
            System.out.println(model.asMap());
            return "redirect:/post/"+ id;
        }
        commentService.addComment(userDetails, comment.getBody(),id);
        return "redirect:/post/"+id;
    }



    @GetMapping("/deleteComment/{id}")
    public String deleteComment(@AuthenticationPrincipal UserDetails userDetails, @PathVariable long id){
        Comment comment =  commentService.commentById(id);
        User user = userService.findUserByUsername(userDetails.getUsername());

        if (user.getId() == comment.getCreator().getId()){
            commentService.deleteComment(comment);
            System.out.println("A comment for a post \""+ comment.getPost().getTitle() +"\" has been deleted.");

            return "redirect:/post/"+comment.getPost().getId();
        }else {
            return "redirect:/post/"+comment.getPost().getId();
        }
    }


}
