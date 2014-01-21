package com.joe.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.joe.bean.Person;
import com.joe.service.IPersonService;

@Transactional
public class PersonServiceBean implements IPersonService{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(Person person) {
		sessionFactory.getCurrentSession().persist(person);
	}
	public void update(Person person) {
		sessionFactory.getCurrentSession().merge(person);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Person getPerson(Integer personId) {
		return (Person)sessionFactory.getCurrentSession().get(Person.class, personId);
	}
	public void delete(Integer personId) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(Person.class, personId)
				);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}
}
