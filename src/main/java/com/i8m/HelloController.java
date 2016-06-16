package com.i8m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i8m.aop.example.SimpleBean;
import com.i8m.aop.example.SomeService;
import com.i8m.payment.audit.AuditJMSService;

@RestController
public class HelloController {

	@Autowired
	AuditJMSService service;

	@Autowired
	SomeService helloService;

	@RequestMapping("/")
	public String index(@RequestBody(required = false) SimpleBean request) {

		if (request == null) {
			return "Hello, annonymous!";
		}

		return helloService.domyJob("Tony", request);
	}

	@RequestMapping("/jms")
	public String jms() {
		service.write("test");
		return "JMS test";
	}

}
