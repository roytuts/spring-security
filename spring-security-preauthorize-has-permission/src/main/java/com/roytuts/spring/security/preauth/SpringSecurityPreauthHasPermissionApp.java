package com.roytuts.spring.security.preauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class SpringSecurityPreauthHasPermissionApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPreauthHasPermissionApp.class, args);
	}

}
