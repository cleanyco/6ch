package com.cleanyco.s6ch.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @NonNull
    String username;
    String password;
    @Column(updatable = false)
    Date createdAt;
    @Column(insertable = false)
    Date updatedAt;

    public User() {}

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = new Date();
    }

    @PreRemove
    private void onDelete() {
        //TODO
    }
}
