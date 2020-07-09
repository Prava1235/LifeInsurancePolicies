package com.employee.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInsuranceApplication.class, args);
	}

}
