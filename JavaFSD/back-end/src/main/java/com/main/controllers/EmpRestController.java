package com.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.Emp;
import com.main.repositories.EmpRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmpRestController {
	
	@Autowired
	EmpRepository repo;
	
	@GetMapping("/employees")
	public List<Emp> getEmployees() {
		return repo.findAll();
	}
	
	@PostMapping("/employees")
	public Emp insertEmployee(@RequestBody Emp e) {
		return repo.save(e);
	}
	
	@PutMapping("/employees")
	public Emp updateEmployee(@RequestBody Emp emp) {
		return repo.save(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Emp> findById(@PathVariable int id) {
		return repo.findById(id);
	}
}
