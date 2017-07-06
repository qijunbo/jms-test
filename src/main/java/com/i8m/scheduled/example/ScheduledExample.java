package com.i8m.scheduled.example;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling

public class ScheduledExample {
	
	@Scheduled(fixedRate = 5000)
	public void  doSomething(){
		
		System.out.println(new Date());
		
	}

}
