package edu.sandip.blog_app_apis.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

	@NotEmpty
	private Integer categoryId;

	@NotEmpty
	@Size(max = 100)
	private String categoryName;

	@Size(max = 100)
	private String categoryDescription;
}
