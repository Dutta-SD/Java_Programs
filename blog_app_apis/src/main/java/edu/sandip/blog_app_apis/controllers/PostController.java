package edu.sandip.blog_app_apis.controllers;


import edu.sandip.blog_app_apis.payloads.ApiResponse;
import edu.sandip.blog_app_apis.payloads.PaginationAndSortingParameters;
import edu.sandip.blog_app_apis.payloads.PostApiGetMethodResponse;
import edu.sandip.blog_app_apis.payloads.PostDTO;
import edu.sandip.blog_app_apis.services.FileService;
import edu.sandip.blog_app_apis.services.PostService;
import edu.sandip.blog_app_apis.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/* TODO: Replace paths with @RequestParam */
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    private final FileService fileService;

    @Autowired
    public PostController(PostService postService, FileService fileService) {
        this.postService = postService;
        this.fileService = fileService;
    }

    @PostMapping("/user/{userId}/categories/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId) {
        PostDTO createdPost = postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    /* get by user */
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostApiGetMethodResponse> getAllPostsBySingleUser(@PathVariable Integer userId,
                                                                            PaginationAndSortingParameters paginationAndSortingParameters) {
        if (noSortByParamInURL(paginationAndSortingParameters)) {
            paginationAndSortingParameters.setSortBy(Constants.ALL_POSTS_DEFAULT_SORT_COLUMN);
        }
        PostApiGetMethodResponse listOfAllPostsBySingleUser = postService.getPostsByUser(userId,
                paginationAndSortingParameters.getPageNumber(),
                paginationAndSortingParameters.getPageSize(),
                paginationAndSortingParameters.getSortBy());
        return ResponseEntity.ok(listOfAllPostsBySingleUser);
    }

    private boolean noSortByParamInURL(PaginationAndSortingParameters paginationAndSortingParameters) {
        return Objects.isNull(paginationAndSortingParameters.getSortBy());
    }

    /* get by category */
    @GetMapping("/categories/{categoryId}/posts")
    public ResponseEntity<PostApiGetMethodResponse> getAllPostsBySingleCategory(@PathVariable Integer categoryId,
                                                                                PaginationAndSortingParameters paginationAndSortingParameters) {
        if (noSortByParamInURL(paginationAndSortingParameters)) {
            paginationAndSortingParameters.setSortBy(Constants.CATEGORY_DEFAULT_SORT_COLUMN);
        }
        PostApiGetMethodResponse allPostsInSingleCategory = postService.getPostsByCategory(categoryId,
                paginationAndSortingParameters.getPageNumber(),
                paginationAndSortingParameters.getPageSize(),
                paginationAndSortingParameters.getSortBy());
        return ResponseEntity.ok(allPostsInSingleCategory);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getSinglePostById(@PathVariable Integer postId) {
        PostDTO postById = postService.getPostById(postId);
        return ResponseEntity.ok(postById);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostApiGetMethodResponse> getAllPosts(
            PaginationAndSortingParameters paginationAndSortingParameters
    ) {
        if (noSortByParamInURL(paginationAndSortingParameters)) {
            paginationAndSortingParameters.setSortBy(Constants.ALL_POSTS_DEFAULT_SORT_COLUMN);
        }
        return ResponseEntity.ok(postService.getAllPost(
                paginationAndSortingParameters.getPageNumber(),
                paginationAndSortingParameters.getPageSize(),
                paginationAndSortingParameters.getSortBy())
        );
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> updatePostByPostId(@PathVariable Integer postId, @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.updatePost(postDTO, postId));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok(getApiResponseWithMessage(Constants.RESOURCE_DELETED_SUCCESSFULLY));
    }

    @GetMapping("/posts/search")
    public List<PostDTO> searchForKeywordInTitle(@RequestParam(name = Constants.KEYWORD) String keyword) {
        return postService.searchPosts(keyword);
    }

    private ApiResponse getApiResponseWithMessage(String apiMessage) {
        ApiResponse successDeletedResponse = new ApiResponse();
        successDeletedResponse.setMessage(apiMessage);
        return successDeletedResponse;
    }

    @PostMapping("/posts/image/upload/{postId}")
    public ResponseEntity<PostDTO> uploadPostImage(@PathVariable Integer postId,
                                                   @RequestParam("image") MultipartFile image) {
        PostDTO postById = postService.getPostById(postId);
        // images/file.xyz like format
        String fileName = fileService.uploadImage(Constants.IMAGE_UPLOAD_FOLDER, image);
        postById.setImageName(fileName);
        PostDTO updatedPostDTO = postService.updatePost(postById, postId);
        return ResponseEntity.ok(updatedPostDTO);
    }
}
