package com.problems.stack;

public class ClosestSmallElement {

    public static void main(String[] args) throws Exception{

        int[] arr= {5,7,3,12,9};
        findClosestSmallest(arr);

    }

    private static void findClosestSmallest(int[] arr) throws StackUnderFlowException {
        StackWithLinkedList stack = new StackWithLinkedList();

        for (int el: arr){
           while(!stack.isEmpty() && stack.peek() > el){
               stack.pop();
           }
           if(stack.isEmpty()){
               System.out.println(-1);
           }else{
               System.out.println(stack.peek());
           }
           stack.push(el);
        }
    }
}
