package com.roytuts.spring.oauth2.sso;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class OAuth2SsoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().and()
				.authorizeRequests(authorize -> authorize.mvcMatchers("/").permitAll().anyRequest().authenticated())
				.oauth2Login().and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}

}
