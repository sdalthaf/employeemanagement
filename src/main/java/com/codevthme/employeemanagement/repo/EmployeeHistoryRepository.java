package com.codevthme.employeemanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.codevthme.employeemanagement.model.Employee;
import com.codevthme.employeemanagement.model.EmployeeHistory;

public interface EmployeeHistoryRepository extends PagingAndSortingRepository<EmployeeHistory, Integer> {

	@Query(nativeQuery =true, value="select * from employment_history where  emp_id =:emp_id order by until_date desc")
	List<EmployeeHistory> findByEmp_Id(Integer emp_id);

}
