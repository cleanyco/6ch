package com.cleanyco.s6ch.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
