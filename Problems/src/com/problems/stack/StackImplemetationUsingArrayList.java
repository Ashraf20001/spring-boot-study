package com.problems.stack;

import java.util.ArrayList;

public class StackImplemetationUsingArrayList {
    public static void main(String[] args) throws Exception {
          Stack myStack = new Stack();
          myStack.push(1);
          myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());


    }
}

class Stack{
    ArrayList al;
    int top;

    public Stack(){
        this.al = new ArrayList<Integer>();
        this.top = -1;
    }

    void push(int element){
        al.add(element);
    }

    int pop() throws StackUnderFlowException{
        try{
            int lastElement = (Integer) al.get(al.size()-1);
            al.remove(al.size()-1);
            return lastElement;
        }catch (Exception e){
            throw new StackUnderFlowException();
        }
    }
}

class StackUnderFlowException extends Exception {
    public  StackUnderFlowException(){
        super("No element is inside stack");
    }
}