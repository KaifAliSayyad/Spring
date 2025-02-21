package com.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.EmpDAO;
import com.main.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmpDAO dao;
	
	public List<Employee> getEmployees(){
		return dao.findAll();
	}
	
	public Optional<Employee> getEmployeeById(int id){
		return dao.findById(id);
	}
	
	public String saveEmployee(Employee e) {
		dao.save(e);
		return "Employee Saved Successfully";
	}
	
	public String updateEmployee(Employee e) {
		if(dao.existsById(e.getEid())) {
			dao.save(e);
			return "Employee Updated Successfully";
		}else return "No Employee with given ID";
	}
	
	public String deleteEmployee(Employee e) {
		if(dao.existsById(e.getEid())) {
			dao.delete(e);
			return "Employee removed successfully";
		}else {
			return "No Employee present with given ID";
		}
	}
	
	public List<Employee> getEmployeeByDesignation(String desig) {
		return dao.getByDesignation(desig);
	}
	
	public List<Employee> getEmployeeByAge(Integer above, Integer below){
		if(above != null) {
			return dao.findByAgeGreaterThan(above.intValue());
		}else {
			return dao.findByAgeLessThan(below.intValue());
		}
	}
	
	public List<Employee> customQuery(String desig){
		return dao.myCustomQuery(desig);
	}
}
