package com.i8m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i8m.payment.audit.AuditJMSService;

@RestController
public class HelloController {

	@Autowired
	AuditJMSService service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/jms")
	public String jms() {
		service.write("test");
		return "JMS test";
	}

}
