package com.joe.service.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.joe.bean.Person;
import com.joe.service.IPersonService;

@Transactional
public class PersonServiceBean implements IPersonService {
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Person person) {
		jdbcTemplate.update("insert into person(name,gender) values(?,?)",
				new Object[]{person.getName(),person.getGender()}, 
				new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR});
	}
	public void update(Person person) {
		jdbcTemplate.update("update person set name=?, gender=? where id=?",
				new Object[]{person.getName(),person.getGender(),person.getId()}, 
				new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Person getPerson(Integer personId) {
		return (Person)jdbcTemplate.queryForObject("select * from person where id=?", 
				new Object[]{personId}, new PersonRowMapper());
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Person> getAllPersons() {
		return (List<Person>)jdbcTemplate.query("select * from person", 
				new PersonRowMapper());
	}
	
	@Transactional(noRollbackFor=RuntimeException.class)
	public void delete(Integer personId) {//throws Exception {
		jdbcTemplate.update("delete from person where id=?",
				new Object[]{personId}, new int[]{java.sql.Types.INTEGER});
//		throw new RuntimeException("a run time exception occurred");
	}
}