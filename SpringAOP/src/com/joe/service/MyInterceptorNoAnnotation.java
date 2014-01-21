package com.joe.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyInterceptorNoAnnotation {
	public void doAccessCheck() {
		System.out.println("前置通知---MyInterceptorNoAnnotation");
	}
	
	public void doAfterReturning() {
		System.out.println("后置通知---MyInterceptorNoAnnotation");
	}
	
	public void doAfter() {
		System.out.println("最终通知---MyInterceptorNoAnnotation");
	}
	
	public void doAfterThrowing() {
		System.out.println("例外通知---MyInterceptorNoAnnotation");
	}
	
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入方法---MyInterceptorNoAnnotation");
		Object o = pjp.proceed();
		System.out.println("退出方法---MyInterceptorNoAnnotation");
		return o;
	}
}