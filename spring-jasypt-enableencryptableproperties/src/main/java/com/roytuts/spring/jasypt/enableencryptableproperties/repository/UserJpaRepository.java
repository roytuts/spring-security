package com.roytuts.spring.jasypt.enableencryptableproperties.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.jasypt.enableencryptableproperties.model.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
