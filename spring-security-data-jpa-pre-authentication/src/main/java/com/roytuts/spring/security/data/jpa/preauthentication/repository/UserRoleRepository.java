package com.roytuts.spring.security.data.jpa.preauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.security.data.jpa.preauthentication.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

	Optional<UserRole> findByUserName(String userName);

}
