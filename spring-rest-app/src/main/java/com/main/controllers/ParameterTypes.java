package com.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.Person;

@RestController
public class ParameterTypes {
	
	@GetMapping("/query")
	public String queryParams(@RequestParam String name,@RequestParam String age) {
//		System.out.println("****FROM '/query'****");
//		System.out.println("Name = "+name);
//		System.out.println("Age  = "+age);
		return "<h3> Hello "+name+", your age is "+age+"</h3>";
	}
	
	@GetMapping("/path/{name}/{age}")
	public String pathParams(@PathVariable String name, @PathVariable String age) {
		return "<h3> Hello "+name+", your age is "+age+"</h3>"; 
	}
	
	@PostMapping("/body")
	public String bodyParams(@RequestBody Person p) {
		return "<h3> Hello "+p.getName()+", your age is "+p.getAge()+"</h3>"; 
	}
	
	@GetMapping(path="/persons", produces="application/xml")			//For complex objects it is application/*
	public List<Person> getPerson() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("A", 21));
		persons.add(new Person("B", 22));
		persons.add(new Person("C", 23));
		persons.add(new Person("D", 24));
		return persons;
	}
}
