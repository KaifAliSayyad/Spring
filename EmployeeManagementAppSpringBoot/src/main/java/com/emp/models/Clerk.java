package com.emp.models;


import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public final class Clerk extends Employee{

	public Clerk() {
		super("CLERK");
	}
    
}