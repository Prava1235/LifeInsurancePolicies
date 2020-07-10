package com.employee.insurance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.insurance.dto.EnrollPolicyDto;
import com.employee.insurance.entity.TrendDetail;
import com.employee.insurance.service.EmployeePoliciesService;
import com.employee.insurance.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employeePolicies")
@Api(description = "Operations Pertaining to Insurance Policies")
public class EmployeePoliciesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePoliciesController.class);
	@Autowired
	EmployeePoliciesService employeePoliciesService;
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/overallTrend")
	@ApiOperation(" Counting available insurance policies")
	public ResponseEntity<List<TrendDetail>> getPoliciesByCounts() throws Exception {
		LOGGER.debug("EmployeePoliciesController :: Get Count No Of Policies :: start");
		List<TrendDetail> employeePolicies = (List<TrendDetail>) employeePoliciesService.getPolicyHolderByCounts();
		LOGGER.debug("EmployeePoliciesController :: Get Count No Of Policies :: end");
		return new ResponseEntity<>(employeePolicies, HttpStatus.OK);
	}
	
	@GetMapping("/currentTrend/{days}")
	@ApiOperation(" Counting Available insurance policies")
	public ResponseEntity<List<TrendDetail>> getPoliciesByDays(@PathVariable("days") long days) throws Exception {
		LOGGER.debug("EmployeePoliciesController :: Get Count No Of Policies by Past Days :: start");
		List<TrendDetail> employeePolicies = (List<TrendDetail>) employeePoliciesService.getPolicyHolderByDays(days);
		LOGGER.debug("EmployeePoliciesController :: Get Count No Of Policies by Past Days :: end");
		return new ResponseEntity<>(employeePolicies, HttpStatus.OK);
	}
	
	
	@PostMapping("/employees/policies")
    public ResponseEntity<String> enrollPolicy(@RequestBody EnrollPolicyDto enrolPolicy) {
        LOGGER.debug("Enroll the policy information");
        return employeePoliciesService.enrolEmployeePolicy(enrolPolicy);

 

    }
	
	//@PostMapping("/enrollpolicy")
//	@ApiOperation("Employee Enroll for Policies")
//	public ResponseEntity<EmployeeResponseDto> enrollPolicies(@RequestBody EmployeeRequestDto requestDto) {
//		log.info("inside registerEmplyee() method ");
//		log.debug("Employee ID "+ requestDto.getEmpId());
//		EmployeeResponseDto response = employeeService.registerEmployee(requestDto);
//		log.info("exiting registerEmployee() method");
//		return new ResponseEntity<EmployeeResponseDto>(response, HttpStatus.OK);
//	}
	

//	@PostMapping("/enrollpolicy")
//	@ApiOperation("Employee Enroll for Policies")
//	public ResponseEntity<EmployeeResponseDto> enrollPolicies(@RequestBody EmployeeRequestDto requestDto) {
//		log.info("inside registerEmplyee() method ");
//		log.debug("Employee ID "+ requestDto.getEmpId());
//		EmployeeResponseDto response = employeeService.registerEmployee(requestDto);
//		log.info("exiting registerEmployee() method");
//		return new ResponseEntity<EmployeeResponseDto>(response, HttpStatus.OK);
//	}

}
