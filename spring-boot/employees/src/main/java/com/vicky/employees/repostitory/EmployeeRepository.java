package com.vicky.employees.repostitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.employees.models.Employee;

@Repository

public interface EmployeeRepository  extends CrudRepository <Employee, Long>{
	
	List<Employee> getEmployeeManager();

}
