package com.i8m.aop.example;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterReturningExample {

    @AfterReturning("execution(* com.i8m.payment.audit.*.write(..))")
    public void doAccessCheck() {
    	System.out.println("I was invoked after returning!");
    }

}