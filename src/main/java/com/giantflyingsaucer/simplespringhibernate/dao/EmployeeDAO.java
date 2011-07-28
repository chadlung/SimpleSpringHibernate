package com.giantflyingsaucer.simplespringhibernate.dao;


import java.util.List;
import com.giantflyingsaucer.simplespringhibernate.entity.Employee;

public interface EmployeeDAO {
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees(Employee employee);
	public Employee getEmployeeById(String employeeId);
	public void deleteEmployee(Employee employee);
}

