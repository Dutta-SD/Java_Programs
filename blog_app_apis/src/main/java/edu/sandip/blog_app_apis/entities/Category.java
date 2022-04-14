package edu.sandip.blog_app_apis.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
}