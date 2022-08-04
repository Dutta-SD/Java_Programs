package edu.sandip.blog_app_apis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDTO category;
    private UserDTO user;
}
