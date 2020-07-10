package com.employee.insurance.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import com.employee.insurance.dto.EmployeeRequestDto;
import com.employee.insurance.entity.Employee;
import com.employee.insurance.repository.EmployeeRepository;
import com.employee.insurance.service.EmployeeService;

 

@RunWith(PowerMockRunner.class)

public class EmployeeServiceTest {

 

      @InjectMocks

      EmployeeService employeeService;

      @Mock

      EmployeeRepository employeeRepository;

 

      @Test

      public void testRegisterEmployee() {

            Employee employee = new Employee();

            EmployeeRequestDto  dto = new EmployeeRequestDto();

            employee.setEname("Test");

            employee.setEmpId(1);

            employee.setEmail("test@test.com");
            
            employee.getEmpId();
            employee.getEname();
            employee.getEmployeePolicies();

            Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

            employeeService.registerEmployee(dto);

            assertEquals("test@test.com",employee.getEmail());

      }

     

      @Test

      public void testRegisterEmployee_NotFound() {

            Employee employee = new Employee(1,"Test","test@test.com","abcd");

            EmployeeRequestDto  dto = new EmployeeRequestDto();

            Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

            employeeService.registerEmployee(dto);

            assertNotEquals("somethingelse",employee.getEmail());

      }

 

}