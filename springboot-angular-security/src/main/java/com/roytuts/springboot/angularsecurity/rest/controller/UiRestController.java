package com.roytuts.springboot.angularsecurity.rest.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UiRestController {

	@GetMapping("/auth")
	public Principal user(Principal user) {
		return user;
	}

	@GetMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");

		return model;
	}

}
