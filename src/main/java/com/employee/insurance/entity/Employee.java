package com.employee.insurance.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@NotNull(message = "ID is required")
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	@Column(name = "ename")
	@NotEmpty(message = "Employee name is required")
	private String ename;
	@Column(name = "email")
	@NotNull(message = "Employee email is required")
	private String email;
	@Column(name = "password")
	@NotNull(message = "Employee password is required")
	private String password;

	public List<EmployeePolicy> getEmployeePolicies() {
		return employeePolicies;
	}

	public void setEmployeePolicies(List<EmployeePolicy> employeePolicies) {
		this.employeePolicies = employeePolicies;
	}

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeePolicy> employeePolicies;

	public Employee() {
		
	}

	public Employee(@NotNull(message = "ID is required") Integer empId,
			@NotEmpty(message = "Employee name is required") String ename,
			@NotNull(message = "Employee email is required") String email,
			@NotNull(message = "Employee password is required") String password) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.email = email;
		this.password = password;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
