import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joe.service.IPersonService;


public class SpringAOPTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSpringInterceptor() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		IPersonService service = (IPersonService)context.getBean("personService");
		service.save("joe");
	}

}
