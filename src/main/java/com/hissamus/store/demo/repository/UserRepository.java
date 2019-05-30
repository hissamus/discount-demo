package com.hissamus.store.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hissamus.store.demo.model.User;
import com.hissamus.store.demo.utils.PropertyHelper;
import com.hissamus.store.demo.utils.UserRowMapper;

@Repository
public class UserRepository  {
	
	@Autowired
	@Qualifier("h2DataSource")
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("h2JDBCTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PropertyHelper sqlPropertyHelper;

	public User findByUsername(@Param("username") String username){
		try {
			User user= jdbcTemplate.queryForObject(sqlPropertyHelper.getProperty("USER_BY_NAME"),new Object[] { username },new UserRowMapper());
			return user;
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return null;
		}	
	}
	
	public List<User> getAllUsers(){
		return jdbcTemplate.query(sqlPropertyHelper.getProperty("All_USERS"),new UserRowMapper());		
	}
}
