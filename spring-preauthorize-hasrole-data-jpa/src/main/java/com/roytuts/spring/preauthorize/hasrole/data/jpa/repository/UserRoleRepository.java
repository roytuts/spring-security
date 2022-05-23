package com.roytuts.spring.preauthorize.hasrole.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.preauthorize.hasrole.data.jpa.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
