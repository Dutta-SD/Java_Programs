package edu.sandip.blog_app_apis.services;

import edu.sandip.blog_app_apis.payloads.UserDTO;

import java.util.List;

public interface UserService {
    //    User createUser(User user);
    //    We use DTO -- Do not expose Entity
    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user, Integer userId);

    UserDTO getUserById(Integer userId);

    List<UserDTO> getAllUsers();

    void deleteUser(Integer userId);
}
