package com.roytuts.spring.preauthorize.haspermission.data.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roytuts.spring.preauthorize.haspermission.data.jpa.entity.User;
import com.roytuts.spring.preauthorize.haspermission.data.jpa.entity.UserRole;
import com.roytuts.spring.preauthorize.haspermission.data.jpa.repository.UserRepository;

@Service
@Transactional
public class UserAuthService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User with '" + username + "' not found.");
		}

		List<UserRole> roles = user.getUserRoles();

		List<GrantedAuthority> grantedAuthorities = roles.stream().map(r -> {
			return new SimpleGrantedAuthority(r.getUserRole());
		}).collect(Collectors.toList());

		org.springframework.security.core.userdetails.User usr = new org.springframework.security.core.userdetails.User(
				user.getUserName(), user.getUserPass(), grantedAuthorities);

		return usr;
	}

}
