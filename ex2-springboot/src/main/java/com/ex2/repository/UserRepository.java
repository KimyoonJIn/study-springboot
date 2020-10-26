package com.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex2.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
