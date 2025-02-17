package com.example.models;

import org.springframework.stereotype.Component;


public class Employee {
	
	public Employee() {
		System.out.println("Employee object has been created!");
	}
	
	
	private String name;
	private int age;
	private float salary;
	private String designation;
	private Address address;
	
	
	
	public Employee(String name, int age, float salary, String designation, Address address) {		
		super();
		System.out.println("Employee(String name, int age, float salary, String designation, Address address).....");
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.address = address;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public float getSalary() {
		return salary;
	}



	public void setSalary(float salary) {
		this.salary = salary;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		System.out.println("Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", designation=" + designation + ", address= "+address+"]");
		return "";
	}
	
	
}
