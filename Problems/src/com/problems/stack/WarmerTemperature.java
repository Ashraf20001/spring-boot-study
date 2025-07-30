package com.problems.stack;

import java.util.Stack;

public class WarmerTemperature {
    public static void main(String[] args) {
        int[] arr= {73,74,75,71,69,72,76,73};
        dailyTemperatures(arr);
    }

    public static int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }

}
