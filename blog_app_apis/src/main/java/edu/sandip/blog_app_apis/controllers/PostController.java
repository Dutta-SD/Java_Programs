package edu.sandip.blog_app_apis.controllers;


import edu.sandip.blog_app_apis.payloads.PostApiGetMethodResponse;
import edu.sandip.blog_app_apis.payloads.PostDTO;
import edu.sandip.blog_app_apis.services.PostService;
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

import java.util.List;

/* TODO: Replace paths with @RequestParam */
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
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
    public ResponseEntity<List<PostDTO>> getAllPostsBySingleUser(@PathVariable Integer userId) {
        List<PostDTO> listOfAllPostsBySingleUser = postService.getPostsByUser(userId);
        return ResponseEntity.ok(listOfAllPostsBySingleUser);
    }

    /* get by category */
    @GetMapping("/categories/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getAllPostsBySingleCategory(@PathVariable Integer categoryId) {
        List<PostDTO> listOfAllPostsInSingleCategory = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(listOfAllPostsInSingleCategory);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getSinglePostById(@PathVariable Integer postId) {
        PostDTO postById = postService.getPostById(postId);
        return ResponseEntity.ok(postById);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostApiGetMethodResponse> getAllPosts(
            @RequestParam(name = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "5", required = false) Integer pageSize
    ) {
        return ResponseEntity.ok(postService.getAllPost(pageNumber, pageSize));
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> updatePostByPostId(@PathVariable Integer postId, @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.updatePost(postDTO, postId));
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePostById(@PathVariable Integer postId) {
        postService.deletePost(postId);
    }

}
