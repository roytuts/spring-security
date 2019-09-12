package com.roytuts.spring.security.preauth.jdbc.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.spring.security.preauth.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int row) throws SQLException {
		User userDetails = new User();
		userDetails.setUsername(rs.getString("user_name"));
		userDetails.setPassword(rs.getString("user_pass"));
		userDetails.setRole(rs.getString("user_role"));
		return userDetails;
	}

}
