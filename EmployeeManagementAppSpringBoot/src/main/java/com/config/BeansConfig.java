package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emp.models.*;

@Configuration
public class BeansConfig {
	
	@Bean("getClerk")
	public Employee getClerk() {
		Employee emp = new Clerk();
		return emp;
	}
}
