package com.roytuts.spring.preauthorize.haspermission.data.jpa.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> user() {
		return new ResponseEntity<String>("You have USER role.", HttpStatus.OK);
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN') and hasPermission('hasAccess','READ')")
	public ResponseEntity<String> admin() {
		return new ResponseEntity<String>("You have ADMIN role with READ access.", HttpStatus.OK);
	}

}
