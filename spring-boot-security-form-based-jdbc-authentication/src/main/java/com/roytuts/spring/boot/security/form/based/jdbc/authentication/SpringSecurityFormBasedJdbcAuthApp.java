package com.roytuts.spring.boot.security.form.based.jdbc.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.roytuts.spring.boot.security.form.based.jdbc.authentication")
public class SpringSecurityFormBasedJdbcAuthApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityFormBasedJdbcAuthApp.class, args);
	}

}
