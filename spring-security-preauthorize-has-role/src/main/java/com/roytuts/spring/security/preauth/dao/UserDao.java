package com.roytuts.spring.security.preauth.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.security.preauth.model.Role;
import com.roytuts.spring.security.preauth.model.User;
import com.roytuts.spring.security.preauth.row.mapper.UserRowMapper;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(String username) {
		return jdbcTemplate.queryForObject("select user_name, user_pass from user where user_name = ?",
				new Object[] { username }, new UserRowMapper());
	}

	public List<Role> getRoles(String username) {
		List<Map<String, Object>> results = jdbcTemplate
				.queryForList("select user_role from user_role where user_name = ?", new Object[] { username });
		List<Role> roles = results.stream().map(m -> {
			Role role = new Role();
			role.setRole(String.valueOf(m.get("user_role")));
			return role;
		}).collect(Collectors.toList());
		return roles;
	}

}
