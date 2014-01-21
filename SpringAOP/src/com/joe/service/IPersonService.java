package com.joe.service;

public interface IPersonService {
	public void save(String name);
	public void update(String name, Integer id);
	public String getPersonName(Integer id);
}
