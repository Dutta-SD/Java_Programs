package edu.sandip.blog_app_apis.services.impl;

import edu.sandip.blog_app_apis.entities.User;
import edu.sandip.blog_app_apis.payloads.UserDTO;
import edu.sandip.blog_app_apis.repositories.UserRepository;
import edu.sandip.blog_app_apis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO user) {
        User savedUser = userRepository.save(dtoToUser(user));
        return userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO user, Integer userId) {
        user.setId(userId);
        User updatedUserDTO = dtoToUser(user);
        User savedUser = userRepository.save(updatedUserDTO);
        return userToDto(savedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        Optional<User> userById = userRepository.findById(userId);

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    private User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setAbout(userDTO.getAbout());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    private UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAbout(user.getAbout());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
