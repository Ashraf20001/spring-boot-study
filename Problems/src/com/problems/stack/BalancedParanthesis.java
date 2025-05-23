package com.problems.stack;

public class BalancedParanthesis {
    public static void main(String[] args) throws Exception {
        String paranthesis ="(){}()";
        System.out.println(isBalancedParanthesis(paranthesis));

    }

    private static Boolean isBalancedParanthesis(String paranthesis) throws StackUnderFlowException {
        StackWithLinkedList mystack = new StackWithLinkedList();
        char[] paranthesisCharArray = paranthesis.toCharArray();
        for (char el: paranthesisCharArray){
            if(el == '(' || el == '[' || el == '{'){
                mystack.push(el);
            }else if (!mystack.isEmpty()
                      && (el==')' && mystack.peek() == '(') ||
                    (el == '}' && mystack.peek() == '{') ||
                    (el == ']' && mystack.peek() == '[')){
                mystack.pop();
            } else{
                return false;
            }
        }
        return mystack.isEmpty();

//        Stack<Character> stack = new Stack<>();
//
//        for (char c : s.toCharArray()) {
//            // Push the expected closing bracket
//            if (c == '(') {
//                stack.push(')');
//            } else if (c == '{') {
//                stack.push('}');
//            } else if (c == '[') {
//                stack.push(']');
//            } else {
//                // If stack is empty or top doesn't match, it's invalid
//                if (stack.isEmpty() || stack.pop() != c) {
//                    return false;
//                }
//            }
//        }
//
//        // Stack should be empty if all brackets matched
//        return stack.isEmpty();
    }
}
