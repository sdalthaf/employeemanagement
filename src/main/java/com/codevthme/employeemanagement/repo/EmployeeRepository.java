package com.codevthme.employeemanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codevthme.employeemanagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


	@Query(nativeQuery =true, value="select * from Employees where  gender = :gender and (first_name like %:emp_name% or last_name like %:emp_name%) order by first_name asc, emp_id asc")
	List<Employee> findBySearch(String emp_name, String gender);

	@Query(nativeQuery =true, value="select * from Employees where  gender = :gender order by first_name asc, emp_id asc")
	List<Employee> findByGender(String gender);

	@Query(nativeQuery =true, value="select * from Employees where  first_name like %:emp_name% or last_name like %:emp_name% order by first_name asc, emp_id asc")
	List<Employee> findByName(String emp_name);

	@Query(nativeQuery = true, value="select * from Employees order by first_name asc, emp_id asc limit 20")
	List<Employee> getAllEmployeesOrderBy();

	
}
