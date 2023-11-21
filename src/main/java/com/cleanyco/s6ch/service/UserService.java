package com.cleanyco.s6ch.service;

import com.cleanyco.s6ch.model.User;
import com.cleanyco.s6ch.payload.UserDTO;
import com.cleanyco.s6ch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public UserDTO mapToDTO(User user) {
        return new UserDTO(user.getUsername(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
