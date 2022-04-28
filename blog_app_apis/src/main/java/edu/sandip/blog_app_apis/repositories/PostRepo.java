package edu.sandip.blog_app_apis.repositories;

import edu.sandip.blog_app_apis.entities.Category;
import edu.sandip.blog_app_apis.entities.Post;
import edu.sandip.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    // Custom Method
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
