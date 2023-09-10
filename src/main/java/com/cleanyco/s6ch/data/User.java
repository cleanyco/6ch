package com.cleanyco.s6ch.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.sql.Timestamp;

@Entity
@Data
public class User {
    @Id
    @NonNull
    String username;
    String password;
    Timestamp createdAt;
    Timestamp deletedAt;

    public User() {
    }
}
