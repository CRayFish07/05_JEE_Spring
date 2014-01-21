package com.joe.service.impl;

import com.joe.service.IPersonService;

public class PersonServiceBean implements IPersonService {

	@Override
	public void save(String name) {
		throw new RuntimeException("runtime exception 111");
//		System.out.println("save() method in PersonServiceBean is called");
	}

	@Override
	public void update(String name, Integer id) {
		System.out.println("update() method in PersonServiceBean is called");
	}

	@Override
	public String getPersonName(Integer id) {
		System.out.println("getPersonName() method in PersonServiceBean is called");
		return "joejoe";
	}

}
