package com.cleanyco.s6ch.repository;

import com.cleanyco.s6ch.model.DeletedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeletedUserRepository extends JpaRepository<DeletedUser, Integer> {

}