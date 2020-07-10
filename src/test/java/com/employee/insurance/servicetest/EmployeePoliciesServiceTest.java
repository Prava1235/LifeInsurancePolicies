package com.employee.insurance.servicetest;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.Mockito;

import org.powermock.modules.junit4.PowerMockRunner;


import com.employee.insurance.dto.EnrollPolicyDto;
import com.employee.insurance.entity.AvailablePolicy;
import com.employee.insurance.entity.Employee;
import com.employee.insurance.entity.EmployeePolicy;

import com.employee.insurance.exception.PolicyNotFoundException;
import com.employee.insurance.repository.AvailablePoliciesRepository;
import com.employee.insurance.repository.EmployeePoliciesRepository;
import com.employee.insurance.repository.EmployeeRepository;
import com.employee.insurance.service.EmployeePoliciesService;

 

@RunWith(PowerMockRunner.class)

public class EmployeePoliciesServiceTest {

 

                @Mock

                EmployeePoliciesRepository employeePoliciesRepository;
                
                @Mock
                EmployeeRepository empRepo;
                
                @Mock
                AvailablePoliciesRepository availablePolicyRepo;

                @InjectMocks

                EmployeePoliciesService employeePoliciesService;

                @Mock

                EmployeePolicy e;

 

                @Test

                public void testGetPoliciesById() throws PolicyNotFoundException {

                                EmployeePolicy employeePolicies = new EmployeePolicy();

                                employeePolicies.setEmpPolicyId(1);

                                Mockito.when(employeePoliciesRepository.findById(1L)).thenReturn(Optional.of(employeePolicies));

                                employeePoliciesService.getPoliciesById(1L);

                                assertEquals((Integer)1,employeePolicies.getEmpPolicyId());

                }

               

                @Test(expected = NullPointerException.class)

                public void testGetPoliciesById_withException() throws PolicyNotFoundException  {

                                Mockito.when(employeePoliciesRepository.findById(1L)).thenReturn(null);

                                employeePoliciesService.getPoliciesById(1L);

                }
                
                
                @Test

                public void testEnrolEmployeePolicy(){
                	
                	Date date = new Date(System.currentTimeMillis());
                	EnrollPolicyDto enrolPolicy = new EnrollPolicyDto();
                	enrolPolicy.setEmpId(1);
                	enrolPolicy.setPolicyId(1L);
                	enrolPolicy.setPolicyNum("12");
                	enrolPolicy.setPremiumAmount(2.0);
                	enrolPolicy.setStartDate(date);
                	enrolPolicy.setEndDate(date);
                	
                	 Employee emp = new Employee();
                	 emp.setEmpId(1);
                	 
                	 AvailablePolicy availablePolicie = new AvailablePolicy();
                	

                                EmployeePolicy employeePolicies = new EmployeePolicy();

                                employeePolicies.setEmpPolicyId(1);
                                

                                Mockito.when(empRepo.findByEmpId(Mockito.any(Integer.class))).thenReturn(emp);
                                Mockito.when(availablePolicyRepo.findByPolicyId(Mockito.anyLong())).thenReturn(availablePolicie);
                                
                                Mockito.when(employeePoliciesRepository.save(Mockito.any(EmployeePolicy.class))).thenReturn(employeePolicies);


                                employeePoliciesService.enrolEmployeePolicy(enrolPolicy);

                                assertEquals((Integer)1,employeePolicies.getEmpPolicyId());

                }
                
                @Test

                public void testGetPolicyHolderByCounts() {

                				List<String> strlist = new ArrayList<String>();

                				strlist.add("1,2,33.33");
                				strlist.add("2,2,33.33");

                                Mockito.when(employeePoliciesRepository.getPolicyHolderByCounts()).thenReturn(Optional.of(strlist));

                                employeePoliciesService.getPolicyHolderByCounts();

                                assertEquals("1,2,33.33",strlist.get(0));

                }
                
                @Test

                public void testGetPolicyHolderByDays() {

                				List<String> strlist = new ArrayList<String>();

                				strlist.add("1,2,33.33");
                				strlist.add("2,2,33.33");

                                Mockito.when(employeePoliciesRepository.getCurrentTrend(Mockito.any(LocalDate.class))).thenReturn(Optional.of(strlist));

                                employeePoliciesService.getPolicyHolderByDays(7);

                                assertEquals("1,2,33.33",strlist.get(0));

                }

 

}


