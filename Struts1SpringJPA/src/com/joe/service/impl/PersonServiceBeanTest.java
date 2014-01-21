package com.joe.service.impl;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.joe.bean.Person;
import com.joe.service.IPersonService;

public class PersonServiceBeanTest {
	private static IPersonService personSercice;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"beans.xml");
			personSercice = (IPersonService) ctx.getBean("personService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		personSercice.save(new Person("haha2","M"));
	}
	@Test
	public void testUpdate() {
		Person p = personSercice.getPerson(1);
		p.setName("haha2");
		personSercice.update(p);
	}
	@Test
	public void testGetPerson() {
		Person p = personSercice.getPerson(1);
		System.out.println(p.getName());
	}
	@Test
	public void testDelete() {
		personSercice.delete(1);
	}
	@Test
	public void testGetAllPersons() {
		List<Person> persons = personSercice.getAllPersons();
		for(Person p:persons) {
			System.out.println(p.getName());
		}
	}
}
