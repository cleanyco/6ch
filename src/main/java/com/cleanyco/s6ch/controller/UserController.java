package com.cleanyco.s6ch.controller;

import com.cleanyco.s6ch.model.User;
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
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);

        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    //TODO add hashing!
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        boolean isExists = userService.isUserExists(user.getUsername());

        if (!isExists) {
            userService.saveUser(user);
            return new ResponseEntity<>("User was successfully created!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
        }
    }
}
