package joe.com.service.aop;

import java.lang.reflect.Method;

import joe.com.service.impl.PersonServiceBean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBProxyFactory implements MethodInterceptor{
	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.targetObject.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("in CGLIBProxyFactory.intercept(), method name:" + method.getName());
		PersonServiceBean bean = (PersonServiceBean)targetObject;
		Object result = null;
		if (bean.getUser() != null) {
			result = methodProxy.invoke(targetObject, args);
		}
		return result;
	}
}
