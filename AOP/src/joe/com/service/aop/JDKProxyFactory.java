package joe.com.service.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import joe.com.service.impl.PersonServiceBean;

//the 3rd param in Proxy.newProxyInstance() needs an InvocationHandler, so this class implements InvocationHandler.
public class JDKProxyFactory implements InvocationHandler {
	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(
				targetObject.getClass().getClassLoader(), 		//target object's class loader
				targetObject.getClass().getInterfaces(), 		//target object's interfaces
				this);
	}

	/**
	 * method: the method you want to call in the target object
	 * args:	params for the method
	 * 
	 * when client wants to call a method in the target, this invoke() will be called first.
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("in JDKProxyFactory.invoke(), method name:" + method.getName());
		PersonServiceBean bean = (PersonServiceBean)targetObject;
		Object result = null;
		if (bean.getUser() != null) {
			result = method.invoke(targetObject, args);
		}
		return result;
	}
}
