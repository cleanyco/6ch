package com.cleanyco.s6ch.service;

import com.cleanyco.s6ch.model.DeletedUser;
import com.cleanyco.s6ch.model.User;
import com.cleanyco.s6ch.payload.UserDTO;
import com.cleanyco.s6ch.repository.DeletedUserRepository;
import com.cleanyco.s6ch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final DeletedUserRepository deletedUserRepository;

    @Autowired
    public UserService(UserRepository repository, DeletedUserRepository deletedUserRepository) {
        this.userRepository = repository;
        this.deletedUserRepository = deletedUserRepository;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveDeletedUser(DeletedUser deletedUser) {
        deletedUserRepository.save(deletedUser);
    }

    public UserDTO mapToDTO(User user) {
        return new UserDTO(user.getUsername(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
