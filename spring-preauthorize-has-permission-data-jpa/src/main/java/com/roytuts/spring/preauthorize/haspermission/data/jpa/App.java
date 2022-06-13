package com.roytuts.spring.preauthorize.haspermission.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.roytuts.spring.preauthorize.haspermission.data.jpa.entity")
@EnableJpaRepositories(basePackages = "com.roytuts.spring.preauthorize.haspermission.data.jpa.repository")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
