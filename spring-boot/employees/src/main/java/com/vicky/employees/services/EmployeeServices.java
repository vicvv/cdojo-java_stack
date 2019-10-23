package com.vicky.employees.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vicky.dojooverview.models.Question;
import com.vicky.employees.models.Employee;
import com.vicky.employees.repostitory.EmployeeRepository;

@Service
public class EmployeeServices {
	
private final EmployeeRepository employeeRepository;
	
	public EmployeeServices (EmployeeRepository employeeRepository) {		
		this.employeeRepository = employeeRepository;
		
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return (List<Employee>)employeeRepository.findAll();
	}
	
	public Employee getOne(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
        	return optionalEmployee.get();
        } else {
            return null;
        }
   	}
	
	public Employee getEmanager() {
		
	}
}
