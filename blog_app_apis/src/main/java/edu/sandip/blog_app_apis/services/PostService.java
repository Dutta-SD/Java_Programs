package edu.sandip.blog_app_apis.services;

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

    /* Get Methods */
    PostApiGetMethodResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy);

    /* Get single Post */
    PostDTO getPostById(Integer postId);

    /* Get All post by category */
    PostApiGetMethodResponse getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy);

    /* Get All posts by user */
    PostApiGetMethodResponse getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize, String sortBy);

    /* Search */
    List<PostDTO> searchPosts(String keyword);

}
