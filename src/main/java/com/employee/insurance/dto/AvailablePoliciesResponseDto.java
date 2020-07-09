package com.employee.insurance.dto;

import java.util.List;

public class AvailablePoliciesResponseDto {
	private String policyDesc;

	private boolean activeStatus;

	public String getPolicyDesc() {
		return policyDesc;
	}

	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

}
