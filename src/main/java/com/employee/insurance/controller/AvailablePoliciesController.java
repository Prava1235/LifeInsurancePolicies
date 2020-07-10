package com.employee.insurance.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.insurance.dto.AvailablePoliciesResponseDto;
import com.employee.insurance.dto.AvailablePoliciesTermAndConditionDto;
import com.employee.insurance.dto.AvailablePolicySalientFeatureResDto;
import com.employee.insurance.entity.AvailablePolicy;
import com.employee.insurance.exception.PolicyNotFoundException;
import com.employee.insurance.service.AvailablePoliciesService;
import com.employee.insurance.service.EmployeePoliciesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/policies")
@Api(description = "Operations Pertaining to Insurance Policies")
public class AvailablePoliciesController {

	@Autowired
	AvailablePoliciesService availablePoliciesService;
	@Autowired
	EmployeePoliciesService employeePoliciesService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AvailablePoliciesController.class);

	@GetMapping
	@ApiOperation("Available insurance policies")
	public ResponseEntity<List<AvailablePolicy>> getPolicies() throws Exception {
		LOGGER.debug("AvailablePoliciesController :: All Policies :: start");
		List<AvailablePolicy> availablePoliciesResponseList = availablePoliciesService.getPolicies();
		LOGGER.debug("AvailablePoliciesController :: All Policies :: end");
		return new ResponseEntity<>(availablePoliciesResponseList, HttpStatus.OK);
	}

	@ApiOperation("Search insurance policies by policy id")
	@GetMapping("/{policyId}")
	public ResponseEntity<AvailablePolicy> getPoliciesById(@PathVariable("policyId") Long policyId)
			throws PolicyNotFoundException {
		LOGGER.info("****Inside available policy method by policy id ****");
		LOGGER.info("search() method called by policyId");
		AvailablePolicy availablePolicies = availablePoliciesService.getPoliciesById(policyId);
		return new ResponseEntity<>(availablePolicies, HttpStatus.OK);
	}

	@ApiOperation("Search insurance policies by policy id")
	@GetMapping("/desc/{policyId}")
	public ResponseEntity<AvailablePoliciesResponseDto> getPoliciesDescById(@PathVariable("policyId") Long policyId)
			throws PolicyNotFoundException {
		LOGGER.info("****Inside available policy method by policy id ****");
		LOGGER.info("search() method called by policyId");
		AvailablePolicy availablePolicies = availablePoliciesService.getPoliciesById(policyId);
		AvailablePoliciesResponseDto availablePoliciesResponseDto = new AvailablePoliciesResponseDto();
		availablePoliciesResponseDto.setPolicyDesc(availablePolicies.getPolicyDesc());
		availablePoliciesResponseDto.setActiveStatus(availablePolicies.isActiveStatus());
		return new ResponseEntity<>(availablePoliciesResponseDto, HttpStatus.OK);
	}

	@ApiOperation("Search salient feature of  policies by policy id")
	@GetMapping("/salientFeatures/{policyId}")
	public ResponseEntity<AvailablePolicySalientFeatureResDto> getPoliciesSalientFeatursById(
			@PathVariable("policyId") Long policyId) throws PolicyNotFoundException {
		LOGGER.info("****Inside available policy method by policy id ****");
		LOGGER.info("search() method called by policyId");
		AvailablePolicy availablePolicies = availablePoliciesService.getPoliciesById(policyId);
		AvailablePolicySalientFeatureResDto availablePolicySalientFeatureResDto = new AvailablePolicySalientFeatureResDto();
		availablePolicySalientFeatureResDto.setSalientFeatures(availablePolicies.getSalientFeatures());
		return new ResponseEntity<>(availablePolicySalientFeatureResDto, HttpStatus.OK);
	}

	@ApiOperation("Search insurance term and condition of  policies by policy id")
	@GetMapping("/Term/{policyId}")
	public ResponseEntity<AvailablePoliciesTermAndConditionDto> getPoliciesTermAndConditionById(
			@PathVariable("policyId") Long policyId)
			throws PolicyNotFoundException {
		LOGGER.info("****Inside available policy method by policy id ****");
		LOGGER.info("search() method called by policyId");
		AvailablePolicy availablePolicies=null;
		AvailablePoliciesTermAndConditionDto availablePoliciesTermAndConditionDto=null;
		availablePolicies = availablePoliciesService.getPoliciesById(policyId);
					availablePoliciesTermAndConditionDto = new AvailablePoliciesTermAndConditionDto();
					availablePoliciesTermAndConditionDto
							.setTermAndCondition(availablePolicies.getTermAndCondition());
		
		
		
		return new ResponseEntity<>(availablePoliciesTermAndConditionDto, HttpStatus.OK);
	}

}
