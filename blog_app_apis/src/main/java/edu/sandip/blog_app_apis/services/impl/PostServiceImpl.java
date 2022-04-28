package edu.sandip.blog_app_apis.services.impl;

import edu.sandip.blog_app_apis.entities.Category;
import edu.sandip.blog_app_apis.entities.Post;
import edu.sandip.blog_app_apis.entities.User;
import edu.sandip.blog_app_apis.exceptions.ResourceNotFoundException;
import edu.sandip.blog_app_apis.payloads.PostDTO;
import edu.sandip.blog_app_apis.repositories.CategoryRepository;
import edu.sandip.blog_app_apis.repositories.PostRepo;
import edu.sandip.blog_app_apis.repositories.UserRepository;
import edu.sandip.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {
        Post post = modelMapper.map(postDTO, Post.class);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("userId", "userId"
                , userId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(
                "categoryId", "categoryId", categoryId));
        // Set additional parameters
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        // Set user and category ID
        post.setCategory(category);
        post.setUser(user);

        // Save post
        postRepo.save(post);

        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
