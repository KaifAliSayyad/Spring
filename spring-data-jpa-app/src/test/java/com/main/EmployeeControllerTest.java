package com.main;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.main.controllers.EmployeeController;
import com.main.entities.Employee;
import com.main.services.EmployeeService;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {
	
	@MockitoBean
	private EmployeeService empService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetEmployees() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(MockMvcResultMatchers.status().is(200));			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetEmployeesAboveAge() {
		try {
			List<Employee> l = new ArrayList<Employee>();
			l.add(new Employee());
			Mockito.when(empService.getEmployeeByDesignation("Tester")).thenReturn(l);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
