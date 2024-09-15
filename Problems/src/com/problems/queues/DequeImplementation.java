package com.problems.queues;

public class DequeImplementation {
    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue();
        dequeue.offerLast(10);
        dequeue.offerFirst(20);
        System.out.println(dequeue.peekFirst());
        System.out.println(dequeue.peekLast());
        dequeue.pollFirst();
        dequeue.pollLast();
        System.out.println(dequeue.peekLast());
        System.out.println(dequeue.peekFirst());
    }
}

class DoublyNode{
    DoublyNode prev;
    int data;
    DoublyNode next;
    public DoublyNode(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Dequeue{

    DoublyNode front;
    DoublyNode rear;
    int size;

    public Dequeue(){
        this.front = null;
        this.rear  = null;
        this.size = 0;
    }

    public void offerFirst(int el){
        DoublyNode nodeToBeAdded = new DoublyNode(el);
        if(front == null && rear == null){
            front = nodeToBeAdded;
            rear = nodeToBeAdded;
        }else{
            front.prev = nodeToBeAdded;
            nodeToBeAdded.next = front;
            front = nodeToBeAdded;
        }
        this.size++;
    }

    public void offerLast(int el){
        DoublyNode nodeToBeAdded = new DoublyNode(el);

        if(front == null && rear == null){
            front = nodeToBeAdded;
            rear = nodeToBeAdded;
        }else{
           rear.next = nodeToBeAdded;
           nodeToBeAdded.prev = rear;
           rear = nodeToBeAdded;
        }
        this.size++;
    }

    public int pollFirst(){
        if(front == null){
            return -1;
        }else if(front.next == null) {
            int temp = front.data;
            front = null;
            rear = null;
            this.size --;
            return temp;
        }
        else{
            int temp = front.data;
            DoublyNode tempNode = front.next;
            front.next = null;
            tempNode.prev = null;
            front = tempNode;
            this.size --;
            return temp;
        }
    }

    public int pollLast(){
        if(rear == null){
            return -1;
        }else if(rear.prev == null) {
            int temp = rear.data;
            rear = null;
            front = null;
            this.size --;
            return temp;
        }else{
            int temp = rear.data;
            DoublyNode tempNode =rear.prev;
            rear.prev = null;
            tempNode.next = null;
            rear = tempNode;
            this.size --;
            return temp;
        }
    }

    public int peekFirst(){
        if(front!=null){
            return front.data;
        }
        return -1;
    }

    public int peekLast(){
        if(rear!=null){
            return rear.data;
        }
        return -1;
    }

    public int getSize(){
        return  this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

}
