package com.roytuts.spring.jasypt.enableencryptableproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.jasypt.enableencryptableproperties.service.UserService;

@SpringBootApplication
public class JasyptEnableEncryptablePropertiesApp implements CommandLineRunner {

	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(JasyptEnableEncryptablePropertiesApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(service.getUserList());
	}

}
