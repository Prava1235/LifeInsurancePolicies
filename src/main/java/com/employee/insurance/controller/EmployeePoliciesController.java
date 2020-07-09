package com.employee.insurance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.insurance.dto.EmployeeRequestDto;
import com.employee.insurance.dto.EmployeeResponseDto;
import com.employee.insurance.dto.EnrollPolicyDto;
import com.employee.insurance.entity.EmployeePolicies;
import com.employee.insurance.service.EmployeePoliciesService;
import com.employee.insurance.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/EmployeePolicies")
@Api(description = "Operations Pertaining to Insurance Policies")
public class EmployeePoliciesController {
	private static final Logger log = LoggerFactory.getLogger(EmployeePoliciesController.class);
	@Autowired
	EmployeePoliciesService employeePoliciesService;
	@Autowired
	EmployeeService employeeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AvailablePoliciesController.class);

	@GetMapping("/OverallTrend")
	@ApiOperation(" Counting Available insurance policies")
	public ResponseEntity<List<EmployeePolicies>> getPoliciesByCounts() throws Exception {
		LOGGER.debug("AvailablePoliciesController :: All Policies :: start");
		List<EmployeePolicies> employeePolicies = (List<EmployeePolicies>) employeePoliciesService.getPolicyHolderByCounts();
		LOGGER.debug("AvailablePoliciesController :: All Policies :: end");
		return new ResponseEntity<>(employeePolicies, HttpStatus.OK);
	}
	
	@GetMapping("/CurrentTrend")
	@ApiOperation(" Counting Available insurance policies")
	public ResponseEntity<List<EmployeePolicies>> getPoliciesByDays() throws Exception {
		LOGGER.debug("AvailablePoliciesController :: All Policies :: start");
		List<EmployeePolicies> employeePolicies = (List<EmployeePolicies>) employeePoliciesService.getPolicyHolderByDays();
		LOGGER.debug("AvailablePoliciesController :: All Policies :: end");
		return new ResponseEntity<>(employeePolicies, HttpStatus.OK);
	}
	
	
	@PostMapping("/employees/policies")
    public ResponseEntity<String> enrollPolicy(@RequestBody EnrollPolicyDto enrolPolicy) {
        LOGGER.debug("enrol the policy information");
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
