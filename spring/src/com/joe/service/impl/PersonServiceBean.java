package com.joe.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.joe.dao.impl.PersonDao;
import com.joe.service.IPersonService;

@Service("personService") //@Scope("prototype")
public class PersonServiceBean implements IPersonService {
	
	private PersonDao personDao;
	
	@Resource
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@PostConstruct
	public void myInit() {
		System.out.println("myInit() is called");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("myDestroy() is called");
	}
	
	@Override
	public void save(){
		personDao.add();
	}
}