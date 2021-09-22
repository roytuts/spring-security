package com.roytuts.spring.security.data.jpa.preauthentication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {

	@Id
	private String userName;
	private String userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
