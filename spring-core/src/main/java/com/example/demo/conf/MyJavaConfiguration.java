package com.example.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.models.Address;
import com.example.models.Employee;
import com.example.models.Student;

@Configuration
public class MyJavaConfiguration {
	
	@Bean("emp")
	@Scope("prototype")
	public Employee getEmployee() {
		return new Employee("Raju", 25, 30000, "TESTER", getAddress());
	}
	
	
	@Bean("student")
	public Student getStudent() {
		return new Student();
	}
	
	@Bean("addr")
	public Address getAddress() {
		Address a = new Address();
		a.setState("Karnataka");
		a.setCity("Bangalore");
		a.setPin(5601001);
		return a;
//		return new Address("Karnataka", "Bangalore", 5601001);
	}
	
	@Bean("emp2")
	public Employee getEmployee2() {
		Employee e = new Employee();
		e.setName("Raju");
		e.setDesignation("TESTER");
		e.setAge(25);
		e.setSalary(35000);
		e.setAddress(getAddress());
		return e;
	}
}
