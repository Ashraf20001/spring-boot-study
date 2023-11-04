package com.demo.learnspringaop.functional.function;

import static com.demo.learnspringaop.functional.function.FunctionalProgramming1.GENDERS.FEMALE;
import static com.demo.learnspringaop.functional.function.FunctionalProgramming1.GENDERS.MALE;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalProgramming1 {
	// Declarative approach
	static Function<List<Person>,List<String>> gendersFromPersonsList= person -> person.stream()
																						.map(aPerson->aPerson.gender.toString())
																						.toList();
	
	
	// BiFunction
	
	static BiFunction<String,String,String> stringConcatOfTwoNames= (name1,name2)->name1+name2;
	
	static Consumer<String> printSomething= string -> System.out.println(string);
	
	public static void main(String[] args) {
		List<Person> person = List.of(
				new Person("Antony", MALE),
				new Person("Jenifer",FEMALE)				
				);
		List<String> gendersFromFunctionalInterface = gendersFromPersonsList.apply(person);
		gendersFromFunctionalInterface.forEach(System.out::println);
		printSomething.accept("Hi da");
	}
	
	static enum GENDERS{
		MALE,FEMALE
	}
	
	static class Person{
		private String firstName;
		private GENDERS gender;
		public Person(String firstName, GENDERS gender) {
			super();
			this.firstName = firstName;
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", gender=" + gender + "]";
		}
		
		
	}
}
