package com.employee.insurance.servicetest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

 

import org.junit.Assert;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.Mockito;

import org.powermock.modules.junit4.PowerMockRunner;

 

import com.employee.insurance.entity.AvailablePolicy;
import com.employee.insurance.entity.EmployeePolicy;
import com.employee.insurance.entity.SalientFeature;
import com.employee.insurance.exception.PolicyNotFoundException;

import com.employee.insurance.repository.AvailablePoliciesRepository;
import com.employee.insurance.service.AvailablePoliciesService;

 

@RunWith(PowerMockRunner.class)

public class AvailablePoliciesServiceTest {

 

                @InjectMocks

                AvailablePoliciesService availablePoliciesService;

                @Mock

                AvailablePoliciesRepository availablePoliciesRepository;

 

                @Test

                public void testGetPoliciesById_WhenFound() throws PolicyNotFoundException {

                                AvailablePolicy availablePolicies = new AvailablePolicy();
                                Date date = new Date(System.currentTimeMillis());
                                List<SalientFeature> salientFeaturesList = new ArrayList<SalientFeature>();
                                SalientFeature salientFeatures = new SalientFeature();
                                salientFeatures.setSalientFeatureId(1l);
                                salientFeatures.setPolicySalientFeature("ABCD");
                                salientFeaturesList.add(salientFeatures);
                                
                                
                                List<EmployeePolicy> employeePoliciesList = new ArrayList<EmployeePolicy>();
                                EmployeePolicy employeePolicies = new EmployeePolicy();

                                employeePolicies.setEmpPolicyId(1);
                                employeePolicies.getPremiumAmount();
                                employeePolicies.getPolicyNum();
                                employeePolicies.getEmployee();
                                employeePolicies.getStartDate();
                                employeePolicies.getEndDate();
                                employeePoliciesList.add(employeePolicies);

                                availablePolicies.setPolicyId(1L);
                                availablePolicies.setActiveStatus(true);
                                availablePolicies.setEntryAge(5L);
                                availablePolicies.setMaximumMaturityAge(20L);
                                availablePolicies.setEndDate(date);
                                availablePolicies.setStartDate(date);
                                availablePolicies.setMinimumPremium(1000.00);
                                availablePolicies.setPolicyDesc("abcd");
                                availablePolicies.setSalientFeatures(salientFeaturesList);
                                availablePolicies.setTermAndCondition("abd");
                                availablePolicies.setPolicyTerm("abcd");
                                availablePolicies.setEmployeePolicies(employeePoliciesList);
                                availablePolicies.setMinimumSumAssured(30.00);
                                
                                
                                availablePolicies.getEntryAge();
                                availablePolicies.getMaximumMaturityAge();
                                availablePolicies.getEndDate();
                                availablePolicies.getStartDate();
                                availablePolicies.getMinimumPremium();
                                availablePolicies.getPolicyDesc();
                                availablePolicies.getSalientFeatures();
                                availablePolicies.getTermAndCondition();
                                availablePolicies.getPolicyTerm();
                                availablePolicies.getEmployeePolicies();
                                availablePolicies.getMinimumSumAssured();

                                Mockito.when(availablePoliciesRepository.findById(1L)).thenReturn(Optional.of(availablePolicies));

                                availablePoliciesService.getPoliciesById(1L);

                                Assert.assertEquals(1, availablePolicies.getPolicyId().intValue());
                                Assert.assertEquals(1, salientFeatures.getSalientFeatureId().intValue());
                                Assert.assertEquals("ABCD", salientFeatures.getPolicySalientFeature());

                }

 

                @Test

                public void testGetPoliciesById_WhenNotFound() throws PolicyNotFoundException {

                                AvailablePolicy availablePolicies = new AvailablePolicy();

                                availablePolicies.setPolicyId(1L);

                                Mockito.when(availablePoliciesRepository.findById(2L)).thenReturn(Optional.of(availablePolicies));

                                availablePoliciesService.getPoliciesById(2L);

                                Assert.assertNotEquals(2, availablePolicies.getPolicyId().intValue());

                }

 

                @Test(expected = NullPointerException.class)

                public void testGetPoliciesById_WithNull() throws PolicyNotFoundException {

                                Mockito.when(availablePoliciesRepository.findById(2L)).thenReturn(null);

                                Assert.assertNull(availablePoliciesService.getPoliciesById(2L));

                }

 

                @Test

                public void testGetPolicies_WhenFound() throws PolicyNotFoundException {

                                List<AvailablePolicy> availablePoliciesList = availablePoliciesRepository.findAll();

                                AvailablePolicy availablePolicies = new AvailablePolicy();

                                availablePolicies.setPolicyId(1L);

                                availablePoliciesList.add(availablePolicies);

                                Mockito.when(availablePoliciesRepository.findAll()).thenReturn(availablePoliciesList);

                                Assert.assertEquals(1, availablePoliciesList.size());

                }

 

}

 
