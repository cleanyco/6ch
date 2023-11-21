package com.cleanyco.s6ch.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "deleted_users")
public class DeletedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    @Column(unique = true, nullable = false)
    String username;
    String password;
    @Column(updatable = false)
    Date createdAt;
    @Column(updatable = false)
    Date lastUpdatedAt;
    @Column(updatable = false)
    Date deletedAt;

    public DeletedUser(String username, String password, Date createdAt, Date lastUpdatedAt, Date deletedAt) {
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.deletedAt = deletedAt;
    }

    public DeletedUser() {}
}
