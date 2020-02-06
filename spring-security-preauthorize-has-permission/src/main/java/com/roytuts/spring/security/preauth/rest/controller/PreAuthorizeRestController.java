package com.roytuts.spring.security.preauth.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreAuthorizeRestController {

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> userRole() {
		return new ResponseEntity<String>("You have USER role", HttpStatus.OK);
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> adminRole() {
		return new ResponseEntity<String>("You have ADMIN role", HttpStatus.OK);
	}

	@GetMapping("/admin/access")
	@PreAuthorize("hasRole('ADMIN') and hasPermission('hasAccess','READ')")
	public ResponseEntity<String> adminAccess() {
		return new ResponseEntity<String>("You have ADMIN role and READ access", HttpStatus.OK);
	}

}
