package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	

	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Before("forDaoPackage()") // match methods in a Package
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()") // @Pointcut is reuseable and applyable to other advices 
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}

}
