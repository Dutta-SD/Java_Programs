package edu.sandip.blog_app_apis.services;

import edu.sandip.blog_app_apis.entities.Post;
import edu.sandip.blog_app_apis.payloads.PostDTO;

import java.util.List;

public interface PostService {
    // Create a Post
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);

    // Update a Post
    PostDTO updatePost(PostDTO postDTO, Integer postId);

    // Delete Post
    void deletePost(Integer postId);

    /* Get Methods */
    // get all posts
    List<Post> getAllPost();

    //Get single Post
    Post getPostById(Integer postId);

    // Get All post by category
    List<Post> getPostsByCategory(Integer categoryId);

    // Get All posts by user
    List<Post> getPostsByUser(Integer userId);

    // Search
    List<Post> searchPosts(String keyword);

}
