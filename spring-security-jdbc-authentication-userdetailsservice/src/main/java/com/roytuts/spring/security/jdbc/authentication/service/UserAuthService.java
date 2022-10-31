package com.roytuts.spring.security.jdbc.authentication.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roytuts.spring.security.jdbc.authentication.dao.UserDao;
import com.roytuts.spring.security.jdbc.authentication.model.UserDetails;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails userDetails = userDao.getUser(username);

		if (userDetails == null) {// should have proper handling of Exception
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userDetails.getRole());

		org.springframework.security.core.userdetails.UserDetails details = new User(userDetails.getUsername(),
				userDetails.getPassword(), Arrays.asList(grantedAuthority));

		return details;
	}
}
