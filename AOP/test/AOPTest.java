import joe.com.service.IPersonService;
import joe.com.service.aop.CGLIBProxyFactory;
import joe.com.service.aop.JDKProxyFactory;
import joe.com.service.impl.PersonServiceBean;

import org.junit.Test;


public class AOPTest {

	@Test
	public void testProxy() {
		JDKProxyFactory factory = new JDKProxyFactory();
		IPersonService personService = (IPersonService)factory.createProxyInstance(new PersonServiceBean("joe"));
		System.out.println("proxy object is created");
		personService.save("xiao");
	}

	@Test
	public void testProxy2() {
		JDKProxyFactory factory = new JDKProxyFactory();
		IPersonService personService = (IPersonService)factory.createProxyInstance(new PersonServiceBean());
		System.out.println("proxy object is created");
		personService.save("xiao");
	}
	
	@Test
	public void testCGLIBProxy() {
		CGLIBProxyFactory factory = new CGLIBProxyFactory();
		PersonServiceBean personService = (PersonServiceBean)factory.createProxyInstance(new PersonServiceBean("xiao"));
		System.out.println("cglib proxy object is created");
		personService.save("big");
	}
	@Test
	public void testCGLIBProxy2() {
		CGLIBProxyFactory factory = new CGLIBProxyFactory();
		PersonServiceBean personService = (PersonServiceBean)factory.createProxyInstance(new PersonServiceBean());
		System.out.println("cglib proxy object is created");
		personService.save("big");
	}
}
