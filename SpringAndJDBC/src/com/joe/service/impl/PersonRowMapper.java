package com.joe.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.joe.bean.Person;

public class PersonRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Person person = new Person(rs.getString("name"),rs.getString("gender"));
		person.setId(rs.getInt("id"));
		return person;
	}

}
