package com.employee.insurance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.insurance.entity.EmployeePolicies;
import com.employee.insurance.service.EmployeePoliciesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/EmployeePolicies")
@Api(description = "Operations Pertaining to Insurance Policies")
public class EmployeePoliciesController {
	private static final Logger log = LoggerFactory.getLogger(EmployeePoliciesController.class);
	@Autowired
	EmployeePoliciesService employeePoliciesService;
	private static final Logger LOGGER = LoggerFactory.getLogger(AvailablePoliciesController.class);

	@GetMapping
	@ApiOperation("Available insurance policies")
	public ResponseEntity<List<EmployeePolicies>> getPoliciesByCounts() throws Exception {
		LOGGER.debug("AvailablePoliciesController :: All Policies :: start");
		List<EmployeePolicies> employeePolicies = (List<EmployeePolicies>) employeePoliciesService.getPolicyHolderByCounts();
		LOGGER.debug("AvailablePoliciesController :: All Policies :: end");
		return new ResponseEntity<>(employeePolicies, HttpStatus.OK);
	}

//	@PostMapping("/registration")
//	@ApiOperation("Employee Registration")
//	public ResponseEntity<EmployeeResponseDto> registerStudent(@RequestBody EmployeeRequestDto requestDto) {
//		log.info("inside registerEmplyee() method ");
//		log.debug("Employee ID "+ requestDto.getEmpId());
//		EmployeeResponseDto response = employeePoliciesService.registerEmployee(requestDto);
//		log.info("exiting registerEmployee() method");
//		return new ResponseEntity<EmployeeResponseDto>(response, HttpStatus.OK);
//	}

}
