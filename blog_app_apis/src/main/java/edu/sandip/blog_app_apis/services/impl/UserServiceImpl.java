package edu.sandip.blog_app_apis.services.impl;

import edu.sandip.blog_app_apis.entities.User;
import edu.sandip.blog_app_apis.exceptions.ResourceNotFoundException;
import edu.sandip.blog_app_apis.payloads.UserDTO;
import edu.sandip.blog_app_apis.repositories.UserRepository;
import edu.sandip.blog_app_apis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO user) {
        User savedUser = userRepository.save(dtoToUser(user));
        return userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userdto, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setId(userdto.getId());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setName(userdto.getName());
        user.setAbout(userdto.getAbout());
        User updatedUser = userRepository.save(user);
        return userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User userById = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return userToDto(userById);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(e -> userToDto(e)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        /* Written like this to handle exception and raise issues */

        User userbyId = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        userRepository.delete(userbyId);
    }

    private User dtoToUser(UserDTO userDTO) {
//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setAbout(userDTO.getAbout());
//        user.setEmail(userDTO.getEmail());
//        user.setName(userDTO.getName());
//        user.setPassword(userDTO.getPassword());
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    private UserDTO userToDto(User user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setAbout(user.getAbout());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setName(user.getName());
//        userDTO.setPassword(user.getPassword());
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}
