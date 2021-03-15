package com.codevthme.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.codevthme.employeemanagement.controller.EmployeeController;
import com.codevthme.employeemanagement.model.Employee;
import com.codevthme.employeemanagement.model.EmployeeHistory;
import com.codevthme.employeemanagement.repo.EmployeeHistoryRepository;
import com.codevthme.employeemanagement.repo.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Value("${male_imagepath}")
	private String male_profile_picture_path;

	@Value("${female_imagepath}")
	private String female_profile_picture_path;

	@Autowired
	private EmployeeHistoryRepository employmenetHistoryRepo;
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	
	public List<Employee> searchEmployee(String emp_id, String emp_name, String gender) {
		
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		if(emp_id.isEmpty() && emp_name.isEmpty() && gender.isEmpty()) {
			listOfEmployees = employeeRepo.getAllEmployeesOrderBy();
		} else if(StringUtils.hasLength(emp_id) && StringUtils.hasText(emp_id)) {
			logger.warn("Searching employee with id : "+emp_id);
			Optional<Employee> employee = employeeRepo.findById(Integer.parseInt(emp_id.trim()));
			
			employee.ifPresent(listOfEmployees :: add);

		} else if(!emp_name.isEmpty() && !gender.isEmpty()){
			logger.warn("Searching employee with gender : "+gender+" and name like : "+emp_name);
			
			employeeRepo.findBySearch(emp_name, gender).forEach(listOfEmployees::add);
		} else if(emp_name.isEmpty() && !gender.isEmpty()) {
			logger.warn("Searching employee with gender : "+gender);
			employeeRepo.findByGender(gender).forEach(listOfEmployees::add);

		} else if(!emp_name.isEmpty() && gender.isEmpty()) {
			logger.warn("Searching employee with name like : "+ emp_name);
			employeeRepo.findByName(emp_name).forEach(listOfEmployees::add);
		}
		
		return listOfEmployees;
	}

	public List<Employee> getAllEmployees() {
		
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			employeeRepo.findAll().forEach(employeeList :: add);
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return employeeList;
	}
	
	public List<Employee> getAllEmployeesOrderBy() {
		
		List<Employee> employeeList = null;
		
		try {
			employeeList = employeeRepo.getAllEmployeesOrderBy();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return employeeList;
	}

	public boolean saveEmployee(Employee employee) {

		boolean saveflag = false;
		if (employee.getGender().equalsIgnoreCase("M")) {
			employee.setProfile_pict(male_profile_picture_path);
		} else {
			 employee.setProfile_pict(female_profile_picture_path);
		}
		
		employee.setEmp_id(getRandomId());
		
		try {
			Employee emp = employeeRepo.save(employee);
			if(emp!=null)
				saveflag = true;
			else
				saveflag = false;
		} catch(Exception e) {
			logger.warn("Faild to save employee");
			saveflag = false;
			logger.error(e.getMessage());
		}
		
		return saveflag;
	}

	private Integer getRandomId() {
			return ThreadLocalRandom.current().ints(111111, 999999).distinct().findFirst().getAsInt();
	}

	public void deleteEmployee(Integer id) {
		
		try {
			
			logger.warn("Deleting Employee.. "+id);
			employeeRepo.deleteById(id);
			
		} catch(Exception e) {
			logger.warn("faild to delete employee : "+id);
			logger.error(e.getMessage());
		}
		
		
	}

	public void updateEmployee(Employee employee) {
		
		if (employee.getGender().equalsIgnoreCase("M")) {
			employee.setProfile_pict(male_profile_picture_path);
		} else {
			 employee.setProfile_pict(female_profile_picture_path);
		}

		try {
			employeeRepo.save(employee);
		} catch(Exception e) {
			logger.warn("Failed to update the employee detaisl");
			logger.error(e.getMessage());
		}
		
	}

	public Employee getEmployeeById(Integer id) {
		logger.warn("Fetching employee with employee id : "+id);
		return employeeRepo.findById(id).get();
	}

	public List<EmployeeHistory> getEmployeeHistory(Integer id) {
		logger.warn("Fetching employment history for : "+id);
		return employmenetHistoryRepo.findByEmp_Id(id);
		
	}
	
}
