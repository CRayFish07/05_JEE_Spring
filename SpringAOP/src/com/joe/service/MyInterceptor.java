package com.joe.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyInterceptor {
	//define when to interceptor.
	@Pointcut("execution (* com.joe.service.impl.PersonServiceBean.*(..))")
	private void anyMethod(){} //declare a pointcut
	
	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name) {
		System.out.println("pre-advice..." + name);
	}
	
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void doAfterReturning(String result) {
		System.out.println("后置通知:" + result);
	}
	
	@After("anyMethod()")
	public void doAfter() {
		System.out.println("最终通知");
	}
	
	@AfterThrowing(pointcut="anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e) {
		System.out.println("例外通知:" + e.getMessage());
	}
	
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入方法");
		Object o = pjp.proceed();
		System.out.println("退出方法");
		return o;
	}
}