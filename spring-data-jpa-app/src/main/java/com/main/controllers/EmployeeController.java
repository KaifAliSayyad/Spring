package com.main.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.dao.EmpDAO;
import com.main.dao2.StudentDAO;
import com.main.entities.Employee;
import com.main.entities.Person;
import com.main.entities.Student;
import com.main.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
//	StudentDAO studentDao;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return empService.getEmployeeById(id);
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee e, @RequestBody Student s) {
		return empService.saveEmployee(e);
	}
	
	
	@RequestMapping(path="/employees", method= {RequestMethod.PATCH, RequestMethod.PUT})
	public String updateEmployee(@RequestBody Employee e) {
		return empService.updateEmployee(e);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@RequestBody Employee e) {
		return empService.deleteEmployee(e);
	}
	
	@GetMapping("/employees/role")
	public List<Employee> getBydesignation(String desig) {
		return empService.getEmployeeByDesignation(desig);
	}
	
	@GetMapping("/employees/age")
	public List<Employee> getEmployeesByAge(Integer above, Integer below){
		return empService.getEmployeeByAge(above, below);
	}
	
	@GetMapping("/employees/custom")
	public List<Employee> getCustomQuery(String desig){
		return empService.customQuery(desig);
	}
	

}
