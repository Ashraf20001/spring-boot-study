package com.demo.learnspringaop.functional.combinatorpattern;

import java.time.LocalDate;
import static com.demo.learnspringaop.functional.combinatorpattern.CustomerRegistrationInterface.isValidAge;
import static com.demo.learnspringaop.functional.combinatorpattern.CustomerRegistrationInterface.isValidName;

public class Main {

	public static void main(String[] args) {
					Customer customer = new Customer(
							"suresh",LocalDate.now().minusYears(11)
							);
					
//					System.out.println(new CustomerValidationServcie().isValidCustomer(customer));
					System.out.println(isValidAge().and(isValidName()).apply(customer));	
		
	}
}
