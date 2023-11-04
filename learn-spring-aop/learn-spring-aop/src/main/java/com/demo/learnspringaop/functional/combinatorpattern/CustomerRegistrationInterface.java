package com.demo.learnspringaop.functional.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import com.demo.learnspringaop.functional.combinatorpattern.CustomerRegistrationInterface.ValidationResult;

public interface CustomerRegistrationInterface extends Function<Customer, ValidationResult>{

	
	
	public static CustomerRegistrationInterface isValidName() {
		return customer->customer.getName()!=null? ValidationResult.SUCCESS:ValidationResult.NAME_NOT_VALID;
	}
	
	
	public static CustomerRegistrationInterface isValidAge() {
		return customer->Period.between(customer.getDob(),LocalDate.now()).getYears()>17 ? ValidationResult.SUCCESS:ValidationResult.AGE_NOT_VALID;
	}
	
	
	
	
	default CustomerRegistrationInterface and (CustomerRegistrationInterface other) {
			return customer -> {
				ValidationResult validationResult = this.apply(customer);
				return validationResult.equals(ValidationResult.SUCCESS)? other.apply(customer):validationResult;
			};
	}
	
	
	
	enum ValidationResult{
		SUCCESS,
		NAME_NOT_VALID,
		AGE_NOT_VALID
	}
}
