package com.roytuts.spring.preauthorize.haspermission.data.jpa.config;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object accessType, Object permission) {
		if (authentication != null && accessType instanceof String) {
			if ("hasAccess".equalsIgnoreCase(String.valueOf(accessType))) {
				boolean hasAccess = validateAccess(String.valueOf(permission));
				return hasAccess;
			}
			return false;
		}
		return false;
	}

	private boolean validateAccess(String permission) {
		// ideally should be checked with user role, permission in database
		if ("READ".equalsIgnoreCase(permission)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable serializable, String targetType,
			Object permission) {
		return false;
	}

}
