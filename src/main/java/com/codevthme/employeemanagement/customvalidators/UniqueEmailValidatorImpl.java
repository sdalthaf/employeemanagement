package com.codevthme.employeemanagement.customvalidators;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codevthme.employeemanagement.controller.EmployeeController;
import com.codevthme.employeemanagement.model.Employee;

public class UniqueEmailValidatorImpl implements ConstraintValidator<UniqueEmailValidator, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		

		if(value==null || EmployeeController.UPDATE_EMPLOYEE_FLAG) {
			return true;
		}
			
		for(Employee e : EmployeeController.currentList) {
			 if(value.equalsIgnoreCase(e.getEmail_id()) || value.equalsIgnoreCase(e.getOffice_mail()))
				 return false;
				 
		}
				
		return true;
	}

}
