package com.employee.insurance.dto;

public class AvailablePoliciesRequestDto {
	private Long policyId;
	private String policyName;
	private String policyDesc;
	private Long entryAge;
	private Long maximumMaturityAge;
	public double getMinimumSumAssured() {
		return minimumSumAssured;
	}
	public void setMinimumSumAssured(double minimumSumAssured) {
		this.minimumSumAssured = minimumSumAssured;
	}
	private String policyTerm;
	private double minimumPremium;
	private double minimumSumAssured;
	private boolean activeStatus;
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
	
}
