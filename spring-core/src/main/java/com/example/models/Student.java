package com.example.models;

import org.springframework.stereotype.Component;

public class Student {
	private int rollNo;
	private String name;
	private int standard;
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", standard=" + standard + "]";
	}
	
	
}
