package com.demo.learnspringaop.functional.function;

import java.util.Optional;

public class _Optional {

		public static void main(String[] args) {
			System.out.println(Optional.ofNullable("value").orElseGet(()->"No Value :)"));
		}
}
