package com.employee.insurance.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.employee.insurance.dto.EnrollPolicyDto;
import com.employee.insurance.entity.AvailablePolicies;
import com.employee.insurance.entity.Employee;
import com.employee.insurance.entity.EmployeePolicies;
import com.employee.insurance.exception.PolicyNotFoundException;
import com.employee.insurance.repository.AvailablePoliciesRepository;
import com.employee.insurance.repository.EmployeePoliciesRepository;
import com.employee.insurance.repository.EmployeeRepository;

@Service
public class EmployeePoliciesService {
	private static final Logger log = LoggerFactory.getLogger(EmployeePoliciesService.class);

	
	
	@Autowired
    EmployeePoliciesRepository employeePoliciesRepository;

    @Autowired
    EmployeeRepository empRepo;

     @Autowired
    AvailablePoliciesRepository availablePolicyRepo;

	public EmployeePolicies getPoliciesById(Long empPolicyId) throws PolicyNotFoundException {
		EmployeePolicies employeePolicies = employeePoliciesRepository.findById(empPolicyId).get();
		log.info("This is getting policies details according to policy_id");
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
	
	public List<?> getPolicyHolderByDays() throws PolicyNotFoundException {
		
		LocalDate date = LocalDate.now();  
		LocalDate pastDate = date.minusDays(7);
		List<?> employeePolicies = employeePoliciesRepository.getCurrentTrend(pastDate);
		employeePolicies.stream().forEach(System.out::println);
		if (Objects.isNull(employeePolicies)) {
			throw new PolicyNotFoundException("Policy Not Found");

		}
		return employeePolicies;
	}
	
	public ResponseEntity<String> enrolEmployeePolicy(EnrollPolicyDto enrolPolicy) {

		 

        EmployeePolicies empPolicies = new EmployeePolicies();
        empPolicies.setStartDate(enrolPolicy.getStartDate());
        empPolicies.setEndDate(enrolPolicy.getEndDate());
        Employee emp = empRepo.findByEmpId(enrolPolicy.getEmpId());
        empPolicies.setEmployee(emp);
        AvailablePolicies availablePolicies = availablePolicyRepo.findByPolicyId(enrolPolicy.getPolicyId());
        empPolicies.setAvailablePolicies(availablePolicies);
        empPolicies.setPremiumAmount(enrolPolicy.getPremiumAmount());
        empPolicies.setPolicyNum(enrolPolicy.getPolicyNum());

 

        employeePoliciesRepository.save(empPolicies);

 

        return new ResponseEntity<String>("The employee insurance enrolled sucessfuly", HttpStatus.CREATED);
    }

}
