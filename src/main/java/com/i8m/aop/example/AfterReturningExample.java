package com.i8m.aop.example;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterReturningExample {

	@AfterReturning(pointcut = "execution(* com.i8m.payment.audit.*.write(..))", returning = "retVal")
	public void doAccessCheck(String retVal) {

		System.out.println(retVal);
		System.out.println("I was invoked after returning!");
	}

}