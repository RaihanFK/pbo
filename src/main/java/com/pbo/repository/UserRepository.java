package com.pbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
