package edu.sandip.blog_app_apis.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer categoryId;

    @Column(name = "title", length = 100, nullable = false, unique = true)
    private String categoryName;

    @Column(name = "description", length = 100)
    private String categoryDescription;


    /* One Category has multiple posts associated with it. Thus, @OneToMany */
    /* Mapped by -- The field that will be mapped in the other entity */
    /* Cascade -- If parent removed then remove child  */
    /* fetch -- Lazy loading.. No unnecessary */

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;

}
