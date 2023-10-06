package com.roytuts.spring.security.preauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.roytuts.spring.security.preauth.permission.CustomPermissionEvaluator;
import com.roytuts.spring.security.preauth.service.UserAuthService;

@Configuration
public class SpringPreAuthorizeSecurityConfig {

	@Autowired
	private CustomPermissionEvaluator permissionEvaluator;
	
	@Autowired
	private UserAuthService userAuthService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*@Autowired
	public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Ideally database authentication is required
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")
				.password("$2a$10$9Xn39aPf4LhDpRGNWvDFqu.T5ZPHbyh8iNQDSb4aNSnLqE2u2efIu").roles("USER").and()
				.passwordEncoder(passwordEncoder).withUser("admin")
				.password("$2a$10$dl8TemMlPH7Z/mpBurCX8O4lu0FoWbXnhsHTYXVsmgXyzagn..8rK").roles("USER", "ADMIN");
	}*/
	
	@Autowired
	public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
		DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
		handler.setPermissionEvaluator(permissionEvaluator);
		return handler;
	}

}
