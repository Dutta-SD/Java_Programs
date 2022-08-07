package edu.sandip.blog_app_apis.payloads;

import edu.sandip.blog_app_apis.utils.Constants;
import lombok.Data;

@Data
public class PaginationAndSortingParameters {
    private Integer pageNumber = Constants.DEFAULT_PAGE_NUMBER;
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    private String sortBy;
    //    TODO: Make sure this is name in query
    private String direction;
}
