package com.joe.service.impl;

import static org.junit.Assert.*;

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
		personSercice.save(new Person("hello Joe","M"));
	}

	@Test
	public void testUpdate() {
		Person person = personSercice.getPerson(1);
		person.setName("helloWorld");
		personSercice.update(person);
	}

	@Test
	public void testGetPerson() {
		Person person = personSercice.getPerson(1);
		System.out.println(person.getName());
		
		try {
			System.out.println("please shutdown mysql in 30 seconds");
			Thread.sleep(1000*30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("second time to retrieve person(1)");
		person = personSercice.getPerson(1);
		System.out.println(person.getName());
	}

	@Test
	public void testDelete() {
		personSercice.delete(1);
	}

	@Test
	public void testGetAllPersons() {
		List<Person> persons = personSercice.getAllPersons();
		for (Person person:persons) {
			System.out.println(person.getName());
		}
	}

}
