package com.codevthme.employeemanagement.customvalidators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DOBValidatorImpl implements ConstraintValidator<DOBValidation, Date>{

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		
		if(value==null) {
			return true;
		}
		
		Calendar calendar  = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -20);
		Date tDate = calendar.getTime();
		if(value.compareTo(tDate)<=0)
			return true;
		
		return false;
	}

}
