package edu.sandip.blog_app_apis.payloads;

import edu.sandip.blog_app_apis.utils.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    @NotEmpty
    private Integer categoryId;

    @NotEmpty
    @Size(max = Constants.CATEGORY_NAME_MAX_LIMIT)
    private String categoryName;

    @Size(max = Constants.CATEGORY_DESCRIPTION_MAX_LIMIT)
    private String categoryDescription;
}
