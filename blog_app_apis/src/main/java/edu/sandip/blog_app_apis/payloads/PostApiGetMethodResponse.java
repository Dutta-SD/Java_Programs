package edu.sandip.blog_app_apis.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostApiGetMethodResponse {
    private List<PostDTO> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private boolean lastPage;
    private int totalPages;
}
