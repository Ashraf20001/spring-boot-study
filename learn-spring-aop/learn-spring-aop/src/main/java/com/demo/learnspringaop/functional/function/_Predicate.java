package com.demo.learnspringaop.functional.function;

import java.util.function.Predicate;

public class _Predicate {

	//Imperative approach
	static boolean checkingAntonyReny(String reny) {
		return reny.startsWith("An") && reny.endsWith("ny");
	}
	
	//Declarative approach
	static Predicate<String> isAntonyPredicate=string->
			string.startsWith("An") && string.endsWith("ny");
	
	public static void main(String[] args) {
		System.out.println(checkingAntonyReny("Antony Reny"));
		
		System.out.println(isAntonyPredicate.test("Antony Reny"));
	}
}
