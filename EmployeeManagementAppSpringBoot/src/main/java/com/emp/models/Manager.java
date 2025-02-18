package com.emp.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("manager")
@Scope("prototype")
public final class Manager extends Employee{

	public Manager() {
		super("MANAGER");
		// TODO Auto-generated constructor stub
	}
	
}