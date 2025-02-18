package com.emp.models;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.emp.utils.Designation;

@Component
@Scope("prototype")
public final class Clerk extends Employee{

	public Clerk() {
		super(Designation.valueOf("CLERK"));
	}
    
}