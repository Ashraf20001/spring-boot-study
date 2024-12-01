package com.problems.function;

@FunctionalInterface
public interface ReverseString<U,T> {
     T  doReverse(U string);
}
