package com.codevthme.employeemanagement.customvalidators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DOBValidatorImpl.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface DOBValidation {

	public String message() default "Age must be >=20";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
}
