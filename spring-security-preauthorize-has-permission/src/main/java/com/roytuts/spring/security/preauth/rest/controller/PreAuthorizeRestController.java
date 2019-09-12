package com.roytuts.spring.security.preauth.rest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreAuthorizeRestController {

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String userRole() {
		return "You have USER role";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminRole() {
		return "You have ADMIN role";
	}

	@GetMapping("/admin/access")
	@PreAuthorize("hasRole('ADMIN') and hasPermission('hasAccess','READ')")
	public String adminAccess() {
		return "You have ADMIN role and READ access";
	}

}
