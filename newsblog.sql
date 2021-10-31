
    create table comment (
       id bigint not null auto_increment,
        body longtext,
        date_created datetime,
        creator_id bigint,
        post_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table post (
       id bigint not null auto_increment,
        body longtext not null,
        date_created datetime,
        title varchar(255) not null,
        views integer not null,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table reply (
       id bigint not null auto_increment,
        body longtext not null,
        data_created varchar(255),
        comment_id bigint,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment
       add constraint FKpv26vrgsh9237ufeforw5yfqu
       foreign key (creator_id)
       references user (id)

    alter table comment
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1
       foreign key (post_id)
       references post (id)

    alter table post
       add constraint FKko69comcms0m0mb60dprlj95r
       foreign key (creator_id)
       references user (id)

    alter table reply
       add constraint FK6w0ns67lrq1jdiwi5xvtj1vxx
       foreign key (comment_id)
       references comment (id)

    alter table reply
       add constraint FKi1vdco77gon1e7eja9o0s0de2
       foreign key (creator_id)
       references user (id)

    alter table user_role
       add constraint FKa68196081fvovjhkek5m97n3y
       foreign key (role_id)
       references role (id)

    alter table user_role
       add constraint FK859n2jvi8ivhui0rl0esws6o
       foreign key (user_id)
       references user (id)

    create table comment (
       id bigint not null auto_increment,
        body longtext,
        date_created datetime,
        creator_id bigint,
        post_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table post (
       id bigint not null auto_increment,
        body longtext not null,
        date_created datetime,
        title varchar(255) not null,
        views integer not null,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table reply (
       id bigint not null auto_increment,
        body longtext not null,
        data_created varchar(255),
        comment_id bigint,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment
       add constraint FKpv26vrgsh9237ufeforw5yfqu
       foreign key (creator_id)
       references user (id)

    alter table comment
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1
       foreign key (post_id)
       references post (id)

    alter table post
       add constraint FKko69comcms0m0mb60dprlj95r
       foreign key (creator_id)
       references user (id)

    alter table reply
       add constraint FK6w0ns67lrq1jdiwi5xvtj1vxx
       foreign key (comment_id)
       references comment (id)

    alter table reply
       add constraint FKi1vdco77gon1e7eja9o0s0de2
       foreign key (creator_id)
       references user (id)

    alter table user_role
       add constraint FKa68196081fvovjhkek5m97n3y
       foreign key (role_id)
       references role (id)

    alter table user_role
       add constraint FK859n2jvi8ivhui0rl0esws6o
       foreign key (user_id)
       references user (id)

    create table comment (
       id bigint not null auto_increment,
        body longtext,
        date_created datetime,
        creator_id bigint,
        post_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table post (
       id bigint not null auto_increment,
        body longtext not null,
        date_created datetime,
        title varchar(255) not null,
        views integer not null,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table reply (
       id bigint not null auto_increment,
        body longtext not null,
        data_created datetime,
        comment_id bigint,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table comment
       add constraint FKpv26vrgsh9237ufeforw5yfqu
       foreign key (creator_id)
       references user (id)

    alter table comment
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1
       foreign key (post_id)
       references post (id)

    alter table post
       add constraint FKko69comcms0m0mb60dprlj95r
       foreign key (creator_id)
       references user (id)

    alter table reply
       add constraint FK6w0ns67lrq1jdiwi5xvtj1vxx
       foreign key (comment_id)
       references comment (id)

    alter table reply
       add constraint FKi1vdco77gon1e7eja9o0s0de2
       foreign key (creator_id)
       references user (id)

    alter table user_role
       add constraint FKa68196081fvovjhkek5m97n3y
       foreign key (role_id)
       references role (id)

    alter table user_role
       add constraint FK859n2jvi8ivhui0rl0esws6o
       foreign key (user_id)
       references user (id)

    create table comment (
       id bigint not null auto_increment,
        body longtext,
        date_created datetime,
        creator_id bigint,
        post_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table post (
       id bigint not null auto_increment,
        average_rating float not null,
        body longtext,
        date_created datetime,
        title varchar(255),
        views integer not null,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table post_reviews (
       post_id bigint not null,
        reviews_id bigint not null
    ) engine=InnoDB

    create table rating (
       id bigint not null auto_increment,
        rating integer not null,
        post_id bigint,
        rater_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table reply (
       id bigint not null auto_increment,
        body longtext,
        date_created datetime,
        comment_id bigint,
        creator_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table review (
       id bigint not null auto_increment,
        review longtext,
        reviewer_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table post_reviews
       add constraint UK_ohmqi2f5njudcb4uharx533ne unique (reviews_id)

    alter table comment
       add constraint FKpv26vrgsh9237ufeforw5yfqu
       foreign key (creator_id)
       references user (id)

    alter table comment
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1
       foreign key (post_id)
       references post (id)

    alter table post
       add constraint FKko69comcms0m0mb60dprlj95r
       foreign key (creator_id)
       references user (id)

    alter table post_reviews
       add constraint FKtm5vfuramq93hltaijvkcddmc
       foreign key (reviews_id)
       references review (id)

    alter table post_reviews
       add constraint FKrbspbptepgymrah7xloe8q3sr
       foreign key (post_id)
       references post (id)

    alter table rating
       add constraint FKq23oorcfn21b1owhgcqle69oq
       foreign key (post_id)
       references post (id)

    alter table rating
       add constraint FKex8dspvwroc3a5h92x5ncj31l
       foreign key (rater_id)
       references user (id)

    alter table reply
       add constraint FK6w0ns67lrq1jdiwi5xvtj1vxx
       foreign key (comment_id)
       references comment (id)

    alter table reply
       add constraint FKi1vdco77gon1e7eja9o0s0de2
       foreign key (creator_id)
       references user (id)

    alter table review
       add constraint FKt58e9mdgxpl7j90ketlaosmx4
       foreign key (reviewer_id)
       references user (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)
