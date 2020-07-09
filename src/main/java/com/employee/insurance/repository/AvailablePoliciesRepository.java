package com.employee.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.insurance.entity.AvailablePolicies;

@Repository
public interface AvailablePoliciesRepository extends JpaRepository<AvailablePolicies, Long> {
	AvailablePolicies findByPolicyId(Long policyid);
}
