package com.employee.insurance.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.insurance.entity.AvailablePolicies;
import com.employee.insurance.exception.PolicyNotFoundException;
import com.employee.insurance.repository.AvailablePoliciesRepository;

@Service
public class AvailablePoliciesService {

	@Autowired
	AvailablePoliciesRepository availablePoliciesRepository;

	public List<AvailablePolicies> getPolicies() throws PolicyNotFoundException {
		
		List<AvailablePolicies> availablePolicies = availablePoliciesRepository.findAll();
		return availablePolicies;
	}

	public AvailablePolicies getPoliciesById(Long policyId) throws PolicyNotFoundException {
		AvailablePolicies availablePolicies = null;
		Optional<AvailablePolicies> availablePoliciesOpt = availablePoliciesRepository.findById(policyId);
		if (availablePoliciesOpt.isPresent()) {
			availablePolicies = availablePoliciesOpt.get();
		}
		else {
			throw new PolicyNotFoundException("Policy Not Found For This Product Code");
		}
		return availablePolicies;
	}
	
}
