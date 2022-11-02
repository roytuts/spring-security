package com.roytuts.spring.security.jdbc.authentication.persistent.rememberme.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roytuts.spring.security.jdbc.authentication.persistent.rememberme.model.UserDetails;
import com.roytuts.spring.security.jdbc.authentication.persistent.rememberme.rowmapper.UserRowMapper;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDetails getUser(String username) {
		try {
			final String sql = "select u.user_name user_name, u.user_pass user_pass, ur.user_role user_role from user u, user_role ur where u.user_name = ? and u.user_name = ur.user_name";

			UserDetails userDetails = jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);

			return userDetails;
		} catch (EmptyResultDataAccessException ex) {
			return null;// should have proper handling of Exception
		}
	}
}
