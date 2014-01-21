package com.joe.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.joe.bean.Person;
import com.joe.service.IPersonService;

@Transactional
public class PersonServiceBean implements IPersonService {
	@PersistenceContext	EntityManager em;
	
	@Override
	public void save(Person person) {
		em.persist(person);
	}
	@Override
	public void update(Person person) {
		em.merge(person);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public Person getPerson(Integer personId) {
		return em.find(Person.class, personId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersons() {
		return em.createQuery("select o from Person o").getResultList();
	}
	@Override
	public void delete(Integer personId) {
		//em.getReference() same as load() in hibernate
		em.remove(em.getReference(Person.class, personId));
	}
}