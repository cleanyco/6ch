package com.cleanyco.s6ch.controller;

import com.cleanyco.s6ch.model.User;
import com.cleanyco.s6ch.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }
    //TODO add hashing!
    //FIXME "created_at" field is not set
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        boolean isExists = isUserExists(user.getUsername());

        if (!isExists) {
            userRepository.save(user);
            return new ResponseEntity<>("User was successfully created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User already exists!d", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isUserExists(String username) {
        return userRepository.existsById(username);
    }
}
