package com.roytuts.spring.security.annotations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("roy")
				.password("{bcrypt}$2a$12$PN0MjtyNGWW.AjWdIuYKxe4.4Grjs4K7oanuAnt/WSDSvFlUc3eQi").roles("ADMIN");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http// ,
				.authorizeRequests()// ,
				.antMatchers("/admin")// Ensures that request with "/admin" to
										// our application requires the user to
										// be authenticated
				.access("hasRole('ADMIN')")// Any URL that starts with
											// "/admin" will
				// be restricted to users who have the
				// role "ROLE_ADMIN",
				.and()// ,
				.formLogin()// Allows users to authenticate with form based
							// login,
				.loginPage("/login")// specifies the location of the log in
									// page,
				.loginProcessingUrl("/j_spring_security_check")// login
																// processing
																// URL,
				.defaultSuccessUrl("/admin")// default-target-url,
				.failureUrl("/login?error")// authentication-failure-url,
				.usernameParameter("username")// overrides Spring's default
												// j_username with
												// username-parameter,
				.passwordParameter("password");// overrides Spring's default
												// j_password with
												// password-parameter

		return http.build();
	}

}
