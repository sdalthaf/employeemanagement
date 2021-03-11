package com.codevthme.employeemanagement.customvalidators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueEmailValidatorImpl.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface UniqueEmailValidator {

	public String message() default "Email already taken!!";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
}
