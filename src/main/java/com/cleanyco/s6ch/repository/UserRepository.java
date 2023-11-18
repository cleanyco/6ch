package com.cleanyco.s6ch.repository;

import com.cleanyco.s6ch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> getUserByUsername(String username);


}
