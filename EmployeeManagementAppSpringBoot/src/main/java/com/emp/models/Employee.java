package com.emp.models;

import com.emp.utils.Menu;

public abstract class Employee {
	private int id;
    private String name;
    private int age;
    private float salary;
    private String designation;
    private String department;



    public Employee(String designation) {
		this.designation = designation;
		while(getDetails());
	}

    private final boolean getDetails() {
		this.id = Menu.readId();
		this.name = Menu.readName();
		this.age = Menu.readAge();
		this.salary = Menu.readSalary();
		return false;
    }

    
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", designation="
				+ designation + "]";
	}
    
    
}