package com.jeejava.spring.security.preauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jeejava.spring.security.preauth")
public class SpringPreAuthentication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPreAuthentication.class, args);
	}

}
