package com.demo.learnspringaop.functional.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationServcie {

	public boolean isValidCustomer(Customer customer) {
		return isValidName(customer.getName()) && isValidAge(customer.getDob());
	}

	private boolean isValidAge(LocalDate dob) {
		return Period.between(dob,LocalDate.now()).getYears()>17;
	}

	private boolean isValidName(String name) {
		return name!=null;
	}
}
