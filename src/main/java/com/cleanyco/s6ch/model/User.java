package com.cleanyco.s6ch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;

@Entity
@Data
public class User {
    @Id
    @NonNull
    String username;
    String password;
    @Column(insertable = false)
    Timestamp createdAt;
    Timestamp deletedAt;

    public User() {
    }
}
