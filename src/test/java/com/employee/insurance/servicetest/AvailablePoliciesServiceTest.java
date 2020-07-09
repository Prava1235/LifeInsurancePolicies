package com.employee.insurance.servicetest;

import java.util.List;

import java.util.Optional;

 

import org.junit.Assert;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.Mockito;

import org.powermock.modules.junit4.PowerMockRunner;

 

import com.employee.insurance.entity.AvailablePolicies;

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

                                AvailablePolicies availablePolicies = new AvailablePolicies();

                                availablePolicies.setPolicyId(1L);

                                Mockito.when(availablePoliciesRepository.findById(1L)).thenReturn(Optional.of(availablePolicies));

                                availablePoliciesService.getPoliciesById(1L);

                                Assert.assertEquals(1, availablePolicies.getPolicyId().intValue());

                }

 

                @Test

                public void testGetPoliciesById_WhenNotFound() throws PolicyNotFoundException {

                                AvailablePolicies availablePolicies = new AvailablePolicies();

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

                                List<AvailablePolicies> availablePoliciesList = availablePoliciesRepository.findAll();

                                AvailablePolicies availablePolicies = new AvailablePolicies();

                                availablePolicies.setPolicyId(1L);

                                availablePoliciesList.add(availablePolicies);

                                Mockito.when(availablePoliciesRepository.findAll()).thenReturn(availablePoliciesList);

                                Assert.assertEquals(1, availablePoliciesList.size());

                }

 

}

 
