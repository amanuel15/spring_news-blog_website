package com.webproject.newsblog.domains;

import com.webproject.newsblog.security.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;
    private Date dateCreated;


    @ManyToOne
    private User creator;

    @ManyToOne
    private Post post;

    @NotBlank(message = "comment body can't be empty.")
    @Size(max = 255, message = "Your comments must less than 255 characters.")
    @Lob
    private String body;

}
