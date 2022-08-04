package edu.sandip.blog_app_apis.controllers;

import edu.sandip.blog_app_apis.payloads.UserDTO;
import edu.sandip.blog_app_apis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/*
 * For all validation, use @Valid before the class to be validated. Here we are validating DTO.
 * So before any UserDTO object, use @Valid
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* POST */
    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userdto) {
        UserDTO user = userService.createUser(userdto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /* PUT */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userdto, @PathVariable Integer id) {
        UserDTO updateUser = userService.updateUser(userdto, id);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
        /* return ResponseEntity.ok(updateUser); -- Also Valid */

    }

    /*DELETE*/
    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDTO> deleteUserById(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();

    }

    /*GET*/
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Integer userId) {
        UserDTO userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById, HttpStatus.ACCEPTED);
    }

    /*GET all*/
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
