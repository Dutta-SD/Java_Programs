package edu.sandip.blog_app_apis.entities;


import edu.sandip.blog_app_apis.utils.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = Constants.POSTS_TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = Constants.POST_TITLE_NAME, length = Constants.MAX_POST_LENGTH, nullable = false)
    private String title;

    @Column(length = Constants.MAX_POST_CONSTANT_LENGTH)
    private String content;
    private String imageName;
    private Date addedDate;

    /* Many to one. JPA manages automatically. Any confusion, see ER diagram*/
    @ManyToOne
    @JoinColumn(name = Constants.POST_TO_CATEGORY_JOIN_COLUMN)
    private Category category;

    @ManyToOne
    private User user;
}
