package com.pbo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findById(String id);
}
