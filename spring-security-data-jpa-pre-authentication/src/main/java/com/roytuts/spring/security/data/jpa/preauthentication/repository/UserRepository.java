package com.roytuts.spring.security.data.jpa.preauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.security.data.jpa.preauthentication.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUserName(String userName);

}
