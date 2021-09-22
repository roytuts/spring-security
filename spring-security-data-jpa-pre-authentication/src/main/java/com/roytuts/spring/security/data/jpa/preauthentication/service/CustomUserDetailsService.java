package com.roytuts.spring.security.data.jpa.preauthentication.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roytuts.spring.security.data.jpa.preauthentication.repository.UserRepository;
import com.roytuts.spring.security.data.jpa.preauthentication.repository.UserRoleRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.roytuts.spring.security.data.jpa.preauthentication.entity.User> user = userRepository
				.findByUserName(username);

		if (!user.isPresent()) {// should have proper handling of Exception
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(
				userRoleRepository.findByUserName(username).get().getUserRole());
		UserDetails details = new org.springframework.security.core.userdetails.User(user.get().getUserName(),
				user.get().getUserPass(), Arrays.asList(grantedAuthority));

		return details;
	}

}
