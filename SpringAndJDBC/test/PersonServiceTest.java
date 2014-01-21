import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joe.bean.Person;
import com.joe.service.IPersonService;

public class PersonServiceTest {
	private static IPersonService personService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		personService = (IPersonService)context.getBean("personService");
	}

	@Test
	public void testSave() {
		for (int i=10;i<15;i++) {
			Person person = new Person("JoeXML" + i,"M");
			personService.save(person);
		}
	}
	
	@Test
	public void testGetPerson() {
		Person person = personService.getPerson(10);
		System.out.println(person.getName()+"," + person.getGender());
	}
	
	@Test
	public void testUpdate() {
		Person person = personService.getPerson(10);
		person.setName("big joe");
		personService.update(person);
	}
	
	@Test
	public void testDelete() {
		try {
			personService.delete(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllPersons() {
		List<Person> persons = personService.getAllPersons();
		for(Person p:persons) {
			System.out.println(p.getName());
		}
	}
}