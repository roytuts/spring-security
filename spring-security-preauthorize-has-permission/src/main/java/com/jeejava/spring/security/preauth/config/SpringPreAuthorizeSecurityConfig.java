package com.jeejava.spring.security.preauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jeejava.spring.security.preauth.permission.CustomPermissionEvaluator;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringPreAuthorizeSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomPermissionEvaluator permissionEvaluator;

	@Autowired
	public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Ideally database authentication is required
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("user")
				.password("$2a$10$9Xn39aPf4LhDpRGNWvDFqu.T5ZPHbyh8iNQDSb4aNSnLqE2u2efIu").roles("USER").and()
				.passwordEncoder(passwordEncoder()).withUser("admin")
				.password("$2a$10$dl8TemMlPH7Z/mpBurCX8O4lu0FoWbXnhsHTYXVsmgXyzagn..8rK").roles("USER", "ADMIN");
	}

	@Bean
	public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
		DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
		handler.setPermissionEvaluator(permissionEvaluator);
		return handler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
