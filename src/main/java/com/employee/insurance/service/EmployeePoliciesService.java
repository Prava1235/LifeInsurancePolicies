package com.employee.insurance.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.insurance.entity.EmployeePolicies;
import com.employee.insurance.exception.PolicyNotFoundException;
import com.employee.insurance.repository.EmployeePoliciesRepository;

@Service
public class EmployeePoliciesService {
	private static final Logger log = LoggerFactory.getLogger(EmployeePoliciesService.class);

	@Autowired
	EmployeePoliciesRepository employeePoliciesRepository;

	public EmployeePolicies getPoliciesById(Long empPolicyId) throws PolicyNotFoundException {
		EmployeePolicies employeePolicies = employeePoliciesRepository.findById(empPolicyId).get();
		if (Objects.isNull(employeePolicies)) {
			throw new PolicyNotFoundException("Policy Not Found");

		}
		return employeePolicies;
	}

	public List<?> getPolicyHolderByCounts() throws PolicyNotFoundException {
		List<?> employeePolicies = employeePoliciesRepository.getPolicyHolderByCounts();
		employeePolicies.stream().forEach(System.out::println);
		if (Objects.isNull(employeePolicies)) {
			throw new PolicyNotFoundException("Policy Not Found");

		}
		return employeePolicies;
	}

}
