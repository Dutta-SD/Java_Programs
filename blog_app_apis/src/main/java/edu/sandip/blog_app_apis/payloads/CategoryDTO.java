package edu.sandip.blog_app_apis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    @NotEmpty
    private Integer categoryId;

    @UniqueElements
    @NotEmpty
    @Size(max = 100)
    private String categoryName;

    @Size(max = 100)
    private String categoryDescription;
}
