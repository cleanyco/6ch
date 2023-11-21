package com.cleanyco.s6ch.repository;

import com.cleanyco.s6ch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getUserByUsername(String username);
}
