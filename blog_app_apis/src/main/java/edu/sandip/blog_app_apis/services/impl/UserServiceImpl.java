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

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        User savedUser = userRepository.save(convertUserDTOtoUser(user));
        return convertUserToUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userdto, Integer userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        updateUserFromDto(userdto, user);
        User updatedUser = userRepository.save(user);
        return convertUserToUserDTO(updatedUser);
    }

    private void updateUserFromDto(UserDTO userdto, User user) {
        user.setId(userdto.getId());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setName(userdto.getName());
        user.setAbout(userdto.getAbout());
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User userById = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return convertUserToUserDTO(userById);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::convertUserToUserDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        /* Written like this to handle exception and raise issues */

        User userbyId = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        userRepository.delete(userbyId);
    }

    private User convertUserDTOtoUser(final UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO convertUserToUserDTO(final User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
