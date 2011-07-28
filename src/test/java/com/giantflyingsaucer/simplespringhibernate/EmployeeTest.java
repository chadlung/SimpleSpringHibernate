package com.giantflyingsaucer.simplespringhibernate;

import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.giantflyingsaucer.simplespringhibernate.dao.*;
import com.giantflyingsaucer.simplespringhibernate.entity.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/app-config.xml" })
public class EmployeeTest {
	private EmployeeDAO dao;

	@Autowired
	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Test
	public void testCreateData() {
		int expectedResult = 1;
		Employee employee = new Employee();
		employee.setEmployeeDepartment("Human Resources");
		employee.setEmployeeName("Barry Jones");
		dao.saveEmployee(employee);
		Assert.assertEquals(expectedResult, dao.getAllEmployees(new Employee()).size());
	}

	@Test
	public void testRetrieveData() {
		List<Employee> employeeList = dao.getAllEmployees(new Employee());
		Assert.assertEquals(1, employeeList.size());
		Employee employeeExpected = employeeList.get(0);
		Employee employeeResult = dao.getEmployeeById(employeeExpected.getEmployeeId());
		Assert.assertEquals(employeeExpected.getEmployeeId(), employeeResult.getEmployeeId());
	}

	@Test
	public void testUpdateData() {
		List<Employee> employeeList = dao.getAllEmployees(new Employee());
		Assert.assertEquals(1, employeeList.size());
		Employee employeeExpected = employeeList.get(0);
		employeeExpected.setEmployeeName("Jim Jones");
		dao.saveEmployee(employeeExpected);
		Employee employeeResult = dao.getEmployeeById(employeeExpected.getEmployeeId());
		Assert.assertEquals(employeeExpected.getEmployeeName(), employeeResult
				.getEmployeeName());
	}

	@Test
	public void testDeleteData() {
		List<Employee> employeeList = dao.getAllEmployees(new Employee());
		Assert.assertEquals(1, employeeList.size());
		Employee employeeExpected = employeeList.get(0);
		dao.deleteEmployee(employeeExpected);
		Employee employeeResult = dao.getEmployeeById(employeeExpected.getEmployeeId());
		Assert.assertEquals(employeeResult, null);
	}
}

