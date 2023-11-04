package com.demo.learnspringaop.functional.function;

import static com.demo.learnspringaop.functional.function._Streams.GENDERS.FEMALE;
import static com.demo.learnspringaop.functional.function._Streams.GENDERS.MALE;

import java.util.List;
import java.util.stream.Collectors;

public class _Streams {
	
	public static void main(String[] args) {
		List<Person> person = List.of(
				new Person("Antony", MALE),
				new Person("Jenifer",FEMALE),
				new Person("Sulaiman",MALE),
				new Person("Khatheeja",FEMALE),
				new Person("Shalini",FEMALE)
				);
		
//		person.stream()
//			  .map(aPerson->aPerson.gender)
//			  .collect(Collectors.toSet())
//			  .forEach(System.out::println);
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
