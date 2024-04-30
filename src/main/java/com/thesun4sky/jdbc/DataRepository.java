package com.thesun4sky.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createTable() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (id SERIAL, name VARCHAR(255))");
	}

	public void insertUser(String name) {
		jdbcTemplate.update("INSERT INTO users (name) VALUES (?)", name);
	}

	public String findUserNameById(Long id) {
		return jdbcTemplate.queryForObject(
			"SELECT name FROM users WHERE id = ?",
			new Object[]{id},
			String.class
		);
	}
}