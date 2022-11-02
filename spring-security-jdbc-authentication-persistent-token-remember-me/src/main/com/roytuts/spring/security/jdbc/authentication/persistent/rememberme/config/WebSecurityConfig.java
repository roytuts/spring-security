package com.roytuts.spring.security.jdbc.authentication.persistent.rememberme.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PersistentTokenRepository persistentTokenRepository;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		final String sqlUserName = "select u.user_name, u.user_pass, u.enable from user u where u.user_name = ?";
		final String sqlAuthorities = "select ur.user_name, ur.user_role from user_role ur where ur.user_name = ?";

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(sqlUserName)
				.authoritiesByUsernameQuery(sqlAuthorities).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http// ,
				.rememberMe() // configure remember me,
				.tokenRepository(persistentTokenRepository) // persistent token for remember me
				.key("rememberKey")// key for remember me,
				.rememberMeParameter("remember")// remember me field name in login form
				.tokenValiditySeconds(86400)// keep valid for one day
				.and()//
				.authorizeRequests()// authorize requests,
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
