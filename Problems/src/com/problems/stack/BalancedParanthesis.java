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
    }
}
