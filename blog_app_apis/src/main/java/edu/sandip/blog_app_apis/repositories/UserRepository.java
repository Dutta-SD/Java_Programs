package edu.sandip.blog_app_apis.repositories;

import edu.sandip.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}