package com.roytuts.spring.boot.security.jwt.auth.api.vo;

import java.util.List;

public class Response {

	private String token;
	private List<String> roles;

	public String getToken() {
		return token;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
