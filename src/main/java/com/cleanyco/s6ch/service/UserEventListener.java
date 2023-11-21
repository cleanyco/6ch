package com.cleanyco.s6ch.service;

import com.cleanyco.s6ch.model.DeletedUser;
import com.cleanyco.s6ch.model.User;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserEventListener {
    UserService userService;

    @Autowired
    public UserEventListener(UserService userService) {
        this.userService = userService;
    }

    public UserEventListener() {}

    @PrePersist
    private void onCreate(User user) {
        user.setCreatedAt(new Date());
    }

    @PreUpdate
    private void onUpdate(User user) {
        user.setUpdatedAt(new Date());
    }

    @PreRemove
    private void onDelete(User user) {
        DeletedUser deletedUser = new DeletedUser(
                user.getUsername(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                new Date()
        );

        userService.saveDeletedUser(deletedUser);
    }
}
