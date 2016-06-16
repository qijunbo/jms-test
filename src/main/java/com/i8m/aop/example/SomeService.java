package com.i8m.aop.example;

import org.springframework.stereotype.Service;

@Service
public class SomeService {

	public String domyJob(String name, SimpleBean request) {

		String result = "Hello, " + name + ".  Your address is " + request.getAddress() + " and your phone number is "
				+ request.getTelphone();
		System.out.println(result);

		return result;

	}
}
