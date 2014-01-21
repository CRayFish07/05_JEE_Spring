package com.joe.web;

import java.util.List;
import javax.annotation.Resource;
import com.joe.bean.Person;
import com.joe.service.IPersonService;

public class PersonAction {
	@Resource IPersonService personService;
	
	private String message;
	private List<Person> persons;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	/**
	 * 人员列表操作
	 * @return
	 */
	public String list() {
		this.persons = personService.getAllPersons();
		return "list";
	}
	
	//此对象来接收添加用户这个页面传来的值
	private Person person;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String addUI() {
		return "add";
	}
	public String add() {
		personService.save(person);
		this.message = "添加完成！";
		return "message";
	}

}
