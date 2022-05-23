package com.roytuts.spring.preauthorize.hasrole.data.jpa.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> defaultPage(Model model) {
		return new ResponseEntity<String>("You have USER role.", HttpStatus.OK);
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> getAllBlogs(Model model) {
		return new ResponseEntity<String>("You have ADMIN role.", HttpStatus.OK);
	}

}
