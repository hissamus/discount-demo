package com.hissamus.store.demo.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hissamus.store.demo.model.User;

public class UserRowMapper implements RowMapper<User> {
	
	private static String IS_AFFLIATED_INDICATOR="IS_AFFLIATED_INDICATOR";
	private static String NAME="NAME";
	private static String IS_EMPLOYEE_INDICATOR="IS_EMPLOYEE_INDICATOR";
	private static String DATE="DATE";
	private static String ID="ID";
	

	@Override
	public User mapRow(ResultSet rs, int index) throws SQLException {
		User user=new User();
		user.setAffliated(rs.getBoolean(IS_AFFLIATED_INDICATOR));
		user.setName(rs.getString(NAME));
		user.setEmployee(rs.getBoolean(IS_EMPLOYEE_INDICATOR));
		user.setDate(rs.getDate(DATE));
		user.setId(rs.getLong(ID));
		return user;
	}

}
