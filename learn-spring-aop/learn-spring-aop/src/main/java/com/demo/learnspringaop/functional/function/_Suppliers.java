package com.demo.learnspringaop.functional.function;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class _Suppliers {

	static Supplier<List<Integer>> getAgeListSupplier=()-> List.of(34,56,7,88,2);
	public static void main(String[] args) {
		System.out.println(getAgeListSupplier.get());
	}
}
