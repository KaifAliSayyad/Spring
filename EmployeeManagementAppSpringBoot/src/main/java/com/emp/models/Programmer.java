package com.emp.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public final class Programmer extends Employee{

	public Programmer() {
		super("PROGRAMMER");
		// TODO Auto-generated constructor stub
	}
	
}