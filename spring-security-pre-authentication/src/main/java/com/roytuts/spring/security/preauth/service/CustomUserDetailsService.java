package com.roytuts.spring.security.preauth.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roytuts.spring.security.preauth.dao.UserDao;
import com.roytuts.spring.security.preauth.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUser(username);
		if (user == null) {// should have proper handling of Exception
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), Arrays.asList(grantedAuthority));
		return details;
	}

}
