package com.joe.dao.impl;

import org.springframework.stereotype.Repository;

import com.joe.dao.IPersonDao;

@Repository
public class PersonDao implements IPersonDao {
	public void add(){
		System.out.println("PersonDao.add() is called");
	};
}
