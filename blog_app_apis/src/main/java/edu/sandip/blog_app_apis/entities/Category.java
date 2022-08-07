package edu.sandip.blog_app_apis.entities;

import edu.sandip.blog_app_apis.utils.Constants;
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


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = Constants.CATEGORIES_TABLE_NAME)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.CATEGORY_ID)
    private Integer categoryId;

    @Column(name = Constants.CATEGORY_NAME, length = Constants.CATEGORY_NAME_MAX_LENGTH, nullable = false, unique = true)
    private String categoryName;

    @Column(name = Constants.CATEGORY_DESCRIPTION, length = Constants.CATEGORY_DESCRIPTION_MAX_LENGTH)
    private String categoryDescription;


    /* One Category has multiple posts associated with it. Thus, @OneToMany */
    /* Mapped by -- The field that will be mapped in the other entity */
    /* Cascade -- If parent removed then remove child  */
    /* fetch -- Lazy loading.. No unnecessary */

    @OneToMany(mappedBy = Constants.CATEGORY_TO_POST_MAPPED_COLUMN, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;

}
