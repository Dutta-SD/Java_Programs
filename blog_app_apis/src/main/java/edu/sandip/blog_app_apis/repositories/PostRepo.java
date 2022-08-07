package edu.sandip.blog_app_apis.repositories;

import edu.sandip.blog_app_apis.entities.Post;
import edu.sandip.blog_app_apis.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Integer> {

    /* Custom Method */
    Optional<Page<Post>> findByCategory_CategoryId(Integer categoryId, Pageable pageable);

    Optional<Page<Post>> findByUser_Id(Integer userId, Pageable pageable);

    List<Post> findByTitleContainingIgnoreCase(@Param(Constants.POST_TITLE_COLUMN) String keyword);

}
