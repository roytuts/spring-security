package com.roytuts.spring.boot.security.jwt.auth.api.rest.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.boot.security.jwt.auth.api.exception.DisabledUserException;
import com.roytuts.spring.boot.security.jwt.auth.api.exception.InvalidUserCredentialsException;
import com.roytuts.spring.boot.security.jwt.auth.api.service.UserAuthService;
import com.roytuts.spring.boot.security.jwt.auth.api.util.JwtUtil;
import com.roytuts.spring.boot.security.jwt.auth.api.vo.Request;
import com.roytuts.spring.boot.security.jwt.auth.api.vo.Response;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class JwtRestApi {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserAuthService userAuthService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/signin")
	public ResponseEntity<Response> generateJwtToken(@RequestBody Request request) {
		Authentication authentication = null;
		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getUserPwd()));
		} catch (DisabledException e) {
			throw new DisabledUserException("User Inactive");
		} catch (BadCredentialsException e) {
			throw new InvalidUserCredentialsException("Invalid Credentials");
		}

		User user = (User) authentication.getPrincipal();
		Set<String> roles = user.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toSet());

		String token = jwtUtil.generateToken(authentication);

		Response response = new Response();
		response.setToken(token);
		response.setRoles(roles.stream().collect(Collectors.toList()));

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody Request request) {
		userAuthService.saveUser(request);

		return new ResponseEntity<String>("User successfully registered", HttpStatus.OK);
	}

}
