package com.giantflyingsaucer.simplespringhibernate.entity;


import javax.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {

	private String employeeId;
	private String name;
	private String department;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "EmployeeId", nullable=false)
	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name = "Name", nullable=false)
	public String getEmployeeName() {
		return this.name;
	}

	public void setEmployeeName(String name) {
		this.name = name;
	}
	@Column(name = "Department", nullable=false)
	public String getEmployeeDepartment() {
		return this.department;
	}

	public void setEmployeeDepartment(String department) {
		this.department = department;
	}
}

