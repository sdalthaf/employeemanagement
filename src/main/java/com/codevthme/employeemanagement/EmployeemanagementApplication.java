package com.codevthme.employeemanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeemanagementApplication {

	public static final Logger logger = LoggerFactory.getLogger(EmployeemanagementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementApplication.class, args);
		
		logger.warn("***Application Started****");
		logger.warn("Access the home page at url **http://localhost:8090/index**");
	}

}
