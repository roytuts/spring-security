package com.roytuts.spring.boot.application.https;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringHttpsApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringHttpsApp.class, args);
	}

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("Welcome to self-certificate https site", HttpStatus.OK);
	}

}
