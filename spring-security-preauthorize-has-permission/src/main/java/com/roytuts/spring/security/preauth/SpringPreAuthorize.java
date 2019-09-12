package com.roytuts.spring.security.preauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.roytuts.spring.security.preauth", exclude = {
		WebMvcAutoConfiguration.class })
public class SpringPreAuthorize {

	public static void main(String[] args) {
		SpringApplication.run(SpringPreAuthorize.class, args);
	}

}
