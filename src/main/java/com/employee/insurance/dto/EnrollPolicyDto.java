package com.employee.insurance.dto;





import java.sql.Date;

 

public class EnrollPolicyDto {
    private double premiumAmount;
    private String policyNum;
    private Date startDate;
    private Date endDate;
    private Long policyId;
    private Integer empId;

 

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

 

    public Long getPolicyId() {
        return policyId;
    }

 

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

 

    public Integer getEmpId() {
        return empId;
    }

 

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

 

}
 