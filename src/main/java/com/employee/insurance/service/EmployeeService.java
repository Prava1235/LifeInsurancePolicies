package com.employee.insurance.service;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.insurance.dto.EmployeeRequestDto;
import com.employee.insurance.dto.EmployeeResponseDto;
import com.employee.insurance.entity.Employee;
import com.employee.insurance.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	private static final Logger log = LoggerFactory.getLogger(EmployeePoliciesService.class);
	public EmployeeResponseDto registerEmployee(EmployeeRequestDto requestDto) {
		Employee employeeEntity = null;
		EmployeeResponseDto responseDto = new EmployeeResponseDto();
		Employee employee2 = new Employee();
		employee2.setEname(requestDto.getEname());
		employee2.setEmpId(requestDto.getEmpId());
		employee2.setPassword(requestDto.getPassword());
		employee2.setEmail(requestDto.getEmail());
		try {
			employeeEntity = employeeRepository.save(employee2);
			} catch (Exception ex) {
				log.error("error while persisting employee entity " + ex.getMessage());
				throw new PersistenceException("registering is unsuccessful");
			}
			if (employeeEntity != null) {
				log.debug("student with his id "+ employeeEntity.getEmpId());
				responseDto.setEmpId(employeeEntity.getEmpId());
				responseDto.setMessage("Employee registered successfully");
			}
			log.info("Employee registered successfully");
			return responseDto;
	}

}
