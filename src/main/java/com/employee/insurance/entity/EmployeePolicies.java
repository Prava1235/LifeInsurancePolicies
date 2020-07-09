package com.employee.insurance.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Employee_Policies")
public class EmployeePolicies  {
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull(message = "Employye policy id is required")
	@Column(name = "emp_policy_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empPolicyId;
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

	public EmployeePolicies() {
		// TODO Auto-generated constructor stub
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	@JsonIgnore
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private AvailablePolicies availablePolicies;

	public AvailablePolicies getAvailablePolicies() {
		return availablePolicies;
	}


	public void setAvailablePolicies(AvailablePolicies availablePolicies) {
		this.availablePolicies = availablePolicies;
	}


	public long getEmpPolicyId() {
		return empPolicyId;
	}

	public void setEmpPolicyId(long empPolicyId) {
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
