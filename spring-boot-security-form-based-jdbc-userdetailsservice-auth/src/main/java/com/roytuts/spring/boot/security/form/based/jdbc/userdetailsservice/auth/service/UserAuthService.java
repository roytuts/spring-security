package com.roytuts.spring.boot.security.form.based.jdbc.userdetailsservice.auth.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roytuts.spring.boot.security.form.based.jdbc.userdetailsservice.auth.dao.UserDao;
import com.roytuts.spring.boot.security.form.based.jdbc.userdetailsservice.auth.model.User;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUser(username);

		if (user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Arrays.asList(grantedAuthority));
	}

}
