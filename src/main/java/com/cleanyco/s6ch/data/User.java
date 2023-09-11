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
@Table(name = "users")
public class User {
    @Id
    @NonNull
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "created_at", insertable = false)
    Timestamp createdAt;
    @Column(name = "deleted_at")
    Timestamp deletedAt;

    public User() {
    }
}
