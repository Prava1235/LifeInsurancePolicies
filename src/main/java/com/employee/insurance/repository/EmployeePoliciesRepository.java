package com.employee.insurance.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.insurance.entity.EmployeePolicy;


@Repository
public interface EmployeePoliciesRepository extends CrudRepository<EmployeePolicy, Long> {
	
	
	@Query(value = "select policy_id,  policy_sum, ROUND(100.0 * policy_sum / (SELECT COUNT(*) FROM EMPLOYEE_POLICIES), 2) AS pct_of_policy from (SELECT policy_id, COUNT(*) AS policy_sum FROM EMPLOYEE_POLICIES group by policy_id) t group by policy_id", nativeQuery = true)
	public Optional<List<String>> getPolicyHolderByCounts();

	
	@Query(value = "select policy_id,  policy_sum, ROUND(100.0 * policy_sum / (SELECT COUNT(*) FROM EMPLOYEE_POLICIES where start_date > ?1), 2) AS pct_of_policy from (SELECT policy_id, COUNT(*) AS policy_sum FROM EMPLOYEE_POLICIES where start_date > ?1 group by policy_id) t group by policy_id", nativeQuery = true)
	public Optional<List<String>> getCurrentTrend(LocalDate date);
	
}
