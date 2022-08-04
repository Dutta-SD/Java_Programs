package edu.sandip.blog_app_apis.services;

import edu.sandip.blog_app_apis.entities.Post;
import edu.sandip.blog_app_apis.payloads.PostApiGetMethodResponse;
import edu.sandip.blog_app_apis.payloads.PostDTO;

import java.util.List;

public interface PostService {
    /* Create a Post */
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);

    /* Update a Post */
    PostDTO updatePost(PostDTO postDTO, Integer postId);

    /* Delete Post */
    void deletePost(Integer postId);

    /*
     Get Methods
     get all posts
    */
    PostApiGetMethodResponse getAllPost(Integer pageNumber, Integer pageSize);

    /* Get single Post */
    PostDTO getPostById(Integer postId);

    /* Get All post by category */
    List<PostDTO> getPostsByCategory(Integer categoryId);

    /* Get All posts by user */
    List<PostDTO> getPostsByUser(Integer userId);

    /* Search */
    List<Post> searchPosts(String keyword);

}
