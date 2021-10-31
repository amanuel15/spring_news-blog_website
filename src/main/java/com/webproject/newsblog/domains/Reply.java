package com.webproject.newsblog.domains;


import com.webproject.newsblog.security.User;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @NotBlank(message = "Reply body can't be blank. ")
    private String body;

    private Date dateCreated;

    @ManyToOne
    private User creator;

    @ManyToOne
    private Comment comment;





}

