package com.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.model.employee;
import com.demo.springboot.services.EmployeeService;


@RestController
public class EmployeeController {
	
	 @Autowired
	 EmployeeService employeeservice;
	 
	 @GetMapping("/employee")
	 private List<employee> getAllEmployees() {
			return employeeservice.getAllEmployees();
		}
	 
	 @GetMapping("/employee/{id}")
		private employee getEmployee(@PathVariable("id") long id) {
			return employeeservice.getEmployeeById(id);
		}
	 
	 @DeleteMapping("/employee/{id}")
		private void deleteEmployee(@PathVariable("id") long id) {
			employeeservice.delete(id);
		}
	 
	 @PostMapping("/employee")
		private long saveEmployee(@RequestBody employee employee) {
			employeeservice.saveOrUpdate(employee);
			return employee.getId();
		}

	 @PutMapping("/employee")
		private employee update(@RequestBody employee employee) {
			employeeservice.saveOrUpdate(employee);
			return employee;
		}
	 
}
