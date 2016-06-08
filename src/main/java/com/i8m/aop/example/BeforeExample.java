package com.i8m.aop.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeExample {

	// @Before( "* com.i8m.payment.audit.AuditJMSService.write(..)" )

	@Before("execution(* com.i8m.payment.audit.*.write(..))")
	public void doAccessCheck() {
		System.out.println("I was invoked!");
	}

}
