package com.jeejava.spring.security.preauth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jeejava.spring.security.preauth.jdbc.row.mapper.UserRowMapper;
import com.jeejava.spring.security.preauth.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(String username) {
		try {
			final String sql = "select u.user_name user_name, u.user_pass user_pass, ur.user_role user_role from user u, user_role ur where u.user_name = ? and u.user_name = ur.user_name";
			User userDetails = jdbcTemplate.queryForObject(sql, new Object[] { username }, new UserRowMapper());
			return userDetails;
		} catch (EmptyResultDataAccessException ex) {
			return null;// should have proper handling of Exception
		}
	}

}
