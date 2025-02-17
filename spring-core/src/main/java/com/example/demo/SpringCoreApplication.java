package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo", "com.example.models"})
@ComponentScan(basePackages = {"com.example"})
public class SpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class, args);
		
//		Object ob1 = ctx.getBean("employee");
		Object ob1 = ctx.getBean("emp2");
		System.out.println(ob1);
		
		Object ob2 = ctx.getBean("student");
		System.out.println(ob2);
		
	}

}
