package com.roytuts.spring.security.preauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roytuts.spring.security.preauth.dao.UserDao;
import com.roytuts.spring.security.preauth.model.Role;
import com.roytuts.spring.security.preauth.model.User;

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

		List<Role> roles = userDao.getRoles(username);

		List<GrantedAuthority> grantedAuthorities = roles.stream().map(r -> {
			return new SimpleGrantedAuthority(r.getRole());
		}).collect(Collectors.toList());

		org.springframework.security.core.userdetails.User usr = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getUserpwd(), grantedAuthorities);

		return usr;
	}

}
