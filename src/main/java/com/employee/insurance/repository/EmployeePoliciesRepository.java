package com.employee.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.insurance.entity.EmployeePolicies;

@Repository
public interface EmployeePoliciesRepository extends CrudRepository<EmployeePolicies, Long> {
	//@Query(value = "select emp_policy_id,policy_id, count(policy_id) from employee_policies group by policy_id" ,nativeQuery = true)
	@Query(value = "select policy_id, count(1) from EMPLOYEE_POLICIES group by policy_id", nativeQuery = true)
	public List<?> getPolicyHolderByCounts();
}
