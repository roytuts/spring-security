package com.roytuts.spring.boot.security.jwt.auth.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.boot.security.jwt.auth.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);

}
