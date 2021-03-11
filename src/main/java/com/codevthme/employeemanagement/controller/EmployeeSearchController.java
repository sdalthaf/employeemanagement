package com.codevthme.employeemanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codevthme.employeemanagement.model.Employee;
import com.codevthme.employeemanagement.service.EmployeeService;

@Controller
public class EmployeeSearchController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeSearchController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/search")
	public ModelAndView searchEmployee(@RequestParam("emp_id") String emp_id, 
			@RequestParam("emp_name") String emp_name, @RequestParam("emp_gender") String gender) {;
		
		logger.warn("Searching the Employee details");
		ModelAndView mv = new ModelAndView();
		List<Employee> employees = employeeService.searchEmployee(emp_id, emp_name, gender);
		mv.addObject("employees", employees);
		mv.setViewName("index");
		
		return mv;
	}
}
