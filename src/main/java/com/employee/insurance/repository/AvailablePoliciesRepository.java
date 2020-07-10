package com.employee.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.insurance.entity.AvailablePolicy;

@Repository
public interface AvailablePoliciesRepository extends JpaRepository<AvailablePolicy, Long> {
	AvailablePolicy findByPolicyId(Long policyid);
}
