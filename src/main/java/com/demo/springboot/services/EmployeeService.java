package com.demo.springboot.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.model.employee;
import com.demo.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

  
	public List<employee> getAllEmployees() {
		List<employee> employee= new ArrayList<employee>();
		employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
		return employee;
	}

	public employee getEmployeeById(long id) {
		return employeeRepository.findById(id).get();
	}

	public void saveOrUpdate(employee employee) {
		employeeRepository.save(employee);
	}


	public void delete(long id) {
		employeeRepository.deleteById(id);
	}

	public void update(employee employee, int id) {
		employeeRepository.save(employee);
	}
}
