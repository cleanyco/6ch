package com.cleanyco.s6ch.controller;

import com.cleanyco.s6ch.controller.exceptions.UserAlreadyExistsException;
import com.cleanyco.s6ch.model.User;
import com.cleanyco.s6ch.payload.UserDTO;
import com.cleanyco.s6ch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
                .map(user -> new ResponseEntity<>(userService.mapToDTO(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        Optional<User> existingUser = userService.getUserByUsername(user.getUsername());

        if (existingUser.isEmpty()) {
            userService.saveUser(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }
}
