package com.employee.insurance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.insurance.entity.EmployeePolicies;

@Repository
public interface EmployeePoliciesRepository extends CrudRepository<EmployeePolicies, Long> {
	//@Query(value = "select emp_policy_id,policy_id, count(policy_id) from employee_policies group by policy_id" ,nativeQuery = true)
	//@Query(value = "select policy_id, count(*) from EMPLOYEE_POLICIES group by policy_id", nativeQuery = true)
	@Query(value = "select policy_id,  policy_sum, ROUND(100.0 * policy_sum / (SELECT COUNT(*) FROM EMPLOYEE_POLICIES), 2) AS pct_of_policy from (SELECT policy_id, COUNT(*) AS policy_sum FROM EMPLOYEE_POLICIES group by policy_id) t group by policy_id", nativeQuery = true)
	public List<?> getPolicyHolderByCounts();
//	@Query("select scx.policyName,count(*) from EmployeePolicy scx where scx.policyPeriodStartDate > ?1 group by scx.policyName ")	
//	List<TrendAnalytics>  getCurrentTrend(LocalDate date);
	
	@Query(value = "select policy_id,  policy_sum, ROUND(100.0 * policy_sum / (SELECT COUNT(*) FROM EMPLOYEE_POLICIES where startDate > ?1), 2) AS pct_of_policy from (SELECT policy_id, COUNT(*) AS policy_sum FROM EMPLOYEE_POLICIES where startDate > ?1 group by policy_id) t where startDate > ?1 group by policy_id", nativeQuery = true)
	public List<?> getCurrentTrend(LocalDate date);
	
}
