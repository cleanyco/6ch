package com.cleanyco.s6ch.payload;


import java.util.Date;

public class UserDTO {
    String username;
    Date createdAt;
    Date updatedAt;

    public UserDTO(String username, Date createdAt, Date updatedAt) {
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
