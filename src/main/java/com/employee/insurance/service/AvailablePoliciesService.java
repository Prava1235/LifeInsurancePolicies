package com.employee.insurance.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.insurance.entity.AvailablePolicy;
import com.employee.insurance.exception.PolicyNotFoundException;
import com.employee.insurance.repository.AvailablePoliciesRepository;

@Service
public class AvailablePoliciesService {

	@Autowired
	AvailablePoliciesRepository availablePoliciesRepository;

	public List<AvailablePolicy> getPolicies() throws PolicyNotFoundException {
		
		List<AvailablePolicy> availablePolicies = availablePoliciesRepository.findAll();
		return availablePolicies;
	}

	public AvailablePolicy getPoliciesById(Long policyId) throws PolicyNotFoundException {
		AvailablePolicy availablePolicies = null;
		Optional<AvailablePolicy> availablePoliciesOpt = availablePoliciesRepository.findById(policyId);
		if (availablePoliciesOpt.isPresent()) {
			availablePolicies = availablePoliciesOpt.get();
		}
		
		return availablePolicies;
	}
	
}
