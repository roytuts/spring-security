package com.roytuts.spring.boot.security.form.based.jdbc.userdetailsservice.auth.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.spring.boot.security.form.based.jdbc.userdetailsservice.auth.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getString("user_name"), rs.getString("user_pass"), rs.getString("user_role"));
	}

}
