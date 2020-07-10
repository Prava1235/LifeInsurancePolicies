package com.employee.insurance.entity;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Employee_Policy")
public class EmployeePolicy  {
	
	@Id
	@NotNull(message = "Employye policy id is required")
	@Column(name = "emp_policy_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empPolicyId;
	@NotNull(message = "premium amount is required")
	@Column(name = "premium_amount")
	private double premiumAmount;
	@NotNull(message = "policy_num is required")
	@Column(name = "policy_num")
	private String policyNum;
	@Column(name = "start_date")
	@NotNull(message = "employee policy date is required")
	private Date startDate;
	@Column(name = "end_date")
	@NotNull(message = "employee policy date is required")
	private Date endDate;
	
	


	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	@JsonIgnore
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private AvailablePolicy availablePolicies;

	public AvailablePolicy getAvailablePolicies() {
		return availablePolicies;
	}


	public void setAvailablePolicies(AvailablePolicy availablePolicies) {
		this.availablePolicies = availablePolicies;
	}


	public Integer getEmpPolicyId() {
		return empPolicyId;
	}

	public void setEmpPolicyId(Integer empPolicyId) {
		this.empPolicyId = empPolicyId;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}


	public String getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	


	
}
