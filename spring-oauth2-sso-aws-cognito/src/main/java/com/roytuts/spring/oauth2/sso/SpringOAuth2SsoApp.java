package com.roytuts.spring.oauth2.sso;

import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class SpringOAuth2SsoApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringOAuth2SsoApp.class, args);
	}

	@GetMapping("/")
	public String home(Model model, Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
			model.addAttribute("name", authentication.getName());
			model.addAttribute("principal", authentication.getPrincipal());
			model.addAttribute("authorities", authentication.getAuthorities().stream().map(a -> a.getAuthority())
					.collect(Collectors.joining(",")));
		}

		model.addAttribute("message", "Spring Boot OAuth2 SSO with AWS Cognito");

		return "index";
	}
}
