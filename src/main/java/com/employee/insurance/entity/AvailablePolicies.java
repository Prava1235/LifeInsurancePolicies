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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AVAILABE_POLICIES")
public class AvailablePolicies  {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "policyId is required")
	@Column(name = "policy_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long policyId;
	@Column(name = "policy_name")
	@NotEmpty(message = "policy name is required")
	private String policyName;
	@Column(name = "policy_desc")
	@NotNull(message = "employee policy desc is required")
	private String policyDesc;
	@Column(name = "entry_age")
	@NotNull(message = "entryAge is required")
	private Long entryAge;

	@NotNull(message = "maximum maturity age is required")
	@Column(name = "maximum_maturity_age")
	private Long maximumMaturityAge;
	@Column(name = "policy_term")
	@NotEmpty(message = "policy term is required")
	private String policyTerm;
	@Column(name = "minimum_premium")
	@NotNull(message = "minimum premium is required")
	private double minimumPremium;
	@Column(name = "minimum_sum_assured")
	@NotNull(message = "minimum_sum_assured is required")
	private double minimumSumAssured;
	@Column(name = "active_status")
	@NotNull(message = "active status is required")
	private boolean activeStatus;
	
	@Column(name = "start_date")
	@NotNull(message = "employee policy date is required")
	private Date startDate;
	@Column(name = "end_date")
	@NotNull(message = "employee policy date is required")
	private Date endDate;

	@OneToMany(mappedBy = "availablePolicies", cascade = CascadeType.ALL)
	private List<SalientFeature> salientFeatures;

	@OneToMany(mappedBy = "availablePolicies", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EmployeePolicies> employeePolicies;
	
	@NotNull(message = "termAndCondition is required")
	@Column(name = "term_and_condition")
	private String termAndCondition;

	public String getTermAndCondition() {
		return termAndCondition;
	}

	public void setTermAndCondition(String termAndCondition) {
		this.termAndCondition = termAndCondition;
	}

	public List<EmployeePolicies> getEmployeePolicies() {
		return employeePolicies;
	}

	public void setEmployeePolicies(List<EmployeePolicies> employeePolicies) {
		this.employeePolicies = employeePolicies;
	}

	public double getMinimumSumAssured() {
		return minimumSumAssured;
	}

	public void setMinimumSumAssured(double minimumSumAssured) {
		this.minimumSumAssured = minimumSumAssured;
	}

	public AvailablePolicies() {
		// TODO Auto-generated constructor stub
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyDesc() {
		return policyDesc;
	}

	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}

	public Long getEntryAge() {
		return entryAge;
	}

	public void setEntryAge(Long entryAge) {
		this.entryAge = entryAge;
	}

	public Long getMaximumMaturityAge() {
		return maximumMaturityAge;
	}

	public void setMaximumMaturityAge(Long maximumMaturityAge) {
		this.maximumMaturityAge = maximumMaturityAge;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

	public double getMinimumPremium() {
		return minimumPremium;
	}

	public void setMinimumPremium(double minimumPremium) {
		this.minimumPremium = minimumPremium;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public List<SalientFeature> getSalientFeatures() {
		return salientFeatures;
	}

	public void setSalientFeatures(List<SalientFeature> salientFeatures) {
		this.salientFeatures = salientFeatures;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
