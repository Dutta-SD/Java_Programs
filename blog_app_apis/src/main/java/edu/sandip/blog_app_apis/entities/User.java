package edu.sandip.blog_app_apis.entities;

import edu.sandip.blog_app_apis.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Constants.USERS_TABLE_NAME)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Constants.USER_ID_COL, nullable = false)
    private Integer id;

    @Column(name = Constants.USER_NAME_COLUMN_NAME, nullable = false, length = Constants.USER_NAME_MAX_LENGTH)
    private String name;
    private String email;
    private String password;
    private String about;

    @OneToMany(mappedBy = Constants.USER_TO_POSTS_MAPPED_COLUMN, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;
}
