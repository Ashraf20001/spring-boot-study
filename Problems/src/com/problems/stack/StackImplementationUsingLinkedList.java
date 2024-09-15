package com.problems.stack;

public class StackImplementationUsingLinkedList {
    public static void main(String[] args) throws Exception{
        StackWithLinkedList myStack = new StackWithLinkedList();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);


        System.out.println(myStack.peek());

//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());

    }
}

class Node {
    int data;
    Node next;
     public Node(int data){
         this.data = data;
         this.next = null;
     }
}

class StackWithLinkedList {
    Node top;
    int size;

    public StackWithLinkedList() {
        this.top = null;
        this.size = 0;
    }

    void push(int el){
        Node newNode = new Node(el);
        if(top == null){
            top = newNode;
        } else {
            newNode.next = top;  // In stack,new elements are
            top = newNode;
        }
        this.size++;
    }

    int pop() throws StackUnderFlowException {
        if(top == null){
            throw new StackUnderFlowException();
        } else{
            int value = top.data;
            top = top.next;
            this.size --;
            return value;
        }
    }

    int size(){
        return  this.size();
    }

    int peek() throws StackUnderFlowException{
        if(top == null){
            throw new StackUnderFlowException();
        } else {
            return top.data;
        }
    }

    boolean isEmpty(){
        return this.top == null;
    }
}
