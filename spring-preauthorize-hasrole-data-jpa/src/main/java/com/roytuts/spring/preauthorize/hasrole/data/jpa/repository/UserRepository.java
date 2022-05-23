package com.roytuts.spring.preauthorize.hasrole.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.preauthorize.hasrole.data.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(final String userName);

}
