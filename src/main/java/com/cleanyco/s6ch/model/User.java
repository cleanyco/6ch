package com.cleanyco.s6ch.model;

import com.cleanyco.s6ch.service.UserEventListener;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
@EntityListeners(UserEventListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    @Column(unique = true, nullable = false)
    String username;
    String password;
    @Column(updatable = false)
    Date createdAt;
    @Column(insertable = false)
    Date updatedAt;

    public User() {}
}
