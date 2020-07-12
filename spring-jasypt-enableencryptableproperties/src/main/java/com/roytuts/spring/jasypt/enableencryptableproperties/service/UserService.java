package com.roytuts.spring.jasypt.enableencryptableproperties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.spring.jasypt.enableencryptableproperties.model.User;
import com.roytuts.spring.jasypt.enableencryptableproperties.repository.UserJpaRepository;

@Service
public class UserService {

	@Autowired
	private UserJpaRepository repository;

	public List<User> getUserList() {
		return repository.findAll();
	}

}
