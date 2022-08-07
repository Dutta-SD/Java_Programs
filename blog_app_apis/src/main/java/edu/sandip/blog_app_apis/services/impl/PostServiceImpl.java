package edu.sandip.blog_app_apis.services.impl;

import edu.sandip.blog_app_apis.entities.Category;
import edu.sandip.blog_app_apis.entities.Post;
import edu.sandip.blog_app_apis.entities.User;
import edu.sandip.blog_app_apis.exceptions.ResourceNotFoundException;
import edu.sandip.blog_app_apis.payloads.PostApiGetMethodResponse;
import edu.sandip.blog_app_apis.payloads.PostDTO;
import edu.sandip.blog_app_apis.repositories.CategoryRepository;
import edu.sandip.blog_app_apis.repositories.PostRepo;
import edu.sandip.blog_app_apis.repositories.UserRepository;
import edu.sandip.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public PostServiceImpl(
            PostRepo postRepo,
            ModelMapper modelMapper,
            UserRepository userRepository,
            CategoryRepository categoryRepository) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {
        Post post = modelMapper.map(postDTO, Post.class);
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("categoryId", "categoryId", categoryId));
        addFieldsToPost(post, user, category);
        // Save post
        Post updatedPost = postRepo.save(post);
        return modelMapper.map(updatedPost, PostDTO.class);
    }

    private void addFieldsToPost(Post post, User user, Category category) {
        // Set additional parameters
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        // Set user and category ID
        post.setCategory(category);
        post.setUser(user);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        return modelMapper.map(
                postRepo.save(modelMapper.map(postDTO, Post.class)),
                PostDTO.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        postRepo.delete(post);
    }

    @Override
    public PostApiGetMethodResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {
        Page<Post> pagePost = postRepo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)));
        return buildPaginatedGetResponse(pagePost);
    }

    private List<PostDTO> getPostDTOList(List<Post> postRepo) {
        return postRepo.stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    private PostApiGetMethodResponse buildPaginatedGetResponse(Page<Post> pagePost) {
        System.out.println(pagePost.getContent());
        return PostApiGetMethodResponse.builder()
                .content(getPostDTOList(pagePost.getContent()))
                .pageNumber(pagePost.getNumber())
                .pageSize(pagePost.getSize())
                .totalElements(pagePost.getTotalElements())
                .lastPage(pagePost.isLast())
                .totalPages(pagePost.getTotalPages())
                .build();
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = postRepo
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public PostApiGetMethodResponse getPostsByCategory(
            Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy
    ) {
        Page<Post> pagePost = postRepo
                .findByCategory_CategoryId(categoryId, PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)))
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        return buildPaginatedGetResponse(pagePost);
    }

    @Override
    public PostApiGetMethodResponse getPostsByUser(
            Integer userId, Integer pageNumber, Integer pageSize, String sortBy
    ) {
        Page<Post> pagePost = postRepo
                .findByUser_Id(userId, PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)))
                .orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
        return buildPaginatedGetResponse(pagePost);
    }

    @Override
    public List<PostDTO> searchPosts(String keyword) {
        return postRepo.findByTitleContainingIgnoreCase(keyword)
                .stream().map((post) -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }
}
