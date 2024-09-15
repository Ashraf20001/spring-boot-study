package com.problems.queues;

public class QueImplementationUsingLinkedList {
    public static void main(String[] args) {
        QueueWithLinkedList linkedListQueue=new QueueWithLinkedList();
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);
        linkedListQueue.enqueue(40);
        linkedListQueue.enqueue(50);

        linkedListQueue.reverseLinkedList();

        System.out.println(linkedListQueue.getFront());
        System.out.println(linkedListQueue.getRear());
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

}


class QueueWithLinkedList {
    Node front;
    Node rear;
    int size;

    public QueueWithLinkedList(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int el){
        Node nodeTobeAdded = new Node(el);
        if(this.rear == null && this.front== null){
            this.front = nodeTobeAdded;
            this.rear  = nodeTobeAdded;
        }else{
           this.rear.next = nodeTobeAdded;
           this.rear = this.rear.next;
        }
        this.size++;
    }

    public int dequeue() {
        if(size>0){
            Node temp = front;
            front = front.next;
            temp.next = null;
            return temp.data;
        }
        return -1;
    }

    public int getFront(){
        return this.front.data;
    }

    public int getRear(){
        return  this.rear.data;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void reverseLinkedList(){
        Node current = null;
        Node prev = null;
        Node next = null;
        current = front;
        while(current!=null){
            next=current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node temp = this.front;
        this.front = this.rear;
        this.rear = temp;
    }
}



