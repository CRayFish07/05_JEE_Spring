package com.joe;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joe.dao.IPersonDao;
import com.joe.service.IPersonService;

public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testInstanceSpring() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		IPersonService personService = (IPersonService)context.getBean("personService");
		
		System.out.println(personService);
		personService.save();
		
		context.close();
	}

}
