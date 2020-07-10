package com.employee.insurance.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.employee.insurance.dto.EnrollPolicyDto;
import com.employee.insurance.entity.AvailablePolicy;
import com.employee.insurance.entity.Employee;
import com.employee.insurance.entity.EmployeePolicy;
import com.employee.insurance.entity.TrendDetail;
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

	public EmployeePolicy getPoliciesById(Long empPolicyId) throws PolicyNotFoundException {
		
		EmployeePolicy employeePolicies = null;
		Optional<EmployeePolicy> employeePoliciesOpt = employeePoliciesRepository.findById(empPolicyId);
		log.info("This is getting policies details according to policy_id");
		if (employeePoliciesOpt.isPresent()) {
			employeePolicies = employeePoliciesOpt.get();
		}
		else {
			throw new PolicyNotFoundException("Policy Not Found");
		}
		return employeePolicies;
	}

	public List<TrendDetail> getPolicyHolderByCounts()  {
		List<TrendDetail> employeePolicieslst = null;
		Optional<List<String>> employeePolicies = employeePoliciesRepository.getPolicyHolderByCounts();
		employeePolicieslst = populateTrendDetail(employeePolicies);
		
		return employeePolicieslst;
	}
	
	public List<TrendDetail> getPolicyHolderByDays(long days)  {
		
		List<TrendDetail> employeePolicieslst = null;
		LocalDate date = LocalDate.now();  
		LocalDate pastDate = date.minusDays(days);
		
		Optional<List<String>> employeePolicies = employeePoliciesRepository.getCurrentTrend(pastDate);
		
		employeePolicieslst = populateTrendDetail(employeePolicies);
		
		return employeePolicieslst;
	}
	
	public List<TrendDetail> populateTrendDetail(Optional<List<String>> employeePolicies) {
		
		List<TrendDetail> employeePolicieslst = null;
		if (employeePolicies.isPresent()) {
			employeePolicieslst = new ArrayList<TrendDetail>();
			for(String str: employeePolicies.get()) {
				String[] strList = str.split(",");
				if(strList.length == 3) {
					TrendDetail trendDetail = new TrendDetail();
					trendDetail.setPolicyId(Integer.parseInt(strList[0]));
					trendDetail.setCount(Integer.parseInt(strList[1]));
					trendDetail.setPercentage(Double.parseDouble(strList[2]));
					employeePolicieslst.add(trendDetail);
				}
			}
			
		}
		
		return employeePolicieslst;
		
	}
	
	public ResponseEntity<String> enrolEmployeePolicy(EnrollPolicyDto enrolPolicy) {

		 

        EmployeePolicy empPolicies = new EmployeePolicy();
        empPolicies.setStartDate(enrolPolicy.getStartDate());
        empPolicies.setEndDate(enrolPolicy.getEndDate());
        Employee emp = empRepo.findByEmpId(enrolPolicy.getEmpId());
        empPolicies.setEmployee(emp);
        AvailablePolicy availablePolicies = availablePolicyRepo.findByPolicyId(enrolPolicy.getPolicyId());
        empPolicies.setAvailablePolicies(availablePolicies);
        empPolicies.setPremiumAmount(enrolPolicy.getPremiumAmount());
        empPolicies.setPolicyNum(enrolPolicy.getPolicyNum());

         employeePoliciesRepository.save(empPolicies);

        return new ResponseEntity<String>("The employee insurance enrolled sucessfuly", HttpStatus.CREATED);
    }

}
