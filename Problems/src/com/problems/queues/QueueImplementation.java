package com.problems.queues;

public class QueueImplementation {
    public static void main(String[] args) {

        ArrQueue arrQueue = new ArrQueue(5);
        arrQueue.enqueue(10);
        arrQueue.enqueue(20);
        arrQueue.enqueue(30);
        System.out.println(arrQueue.getFront());
        System.out.println(arrQueue.getRear());
        arrQueue.enqueue(40);
        arrQueue.enqueue(50);
        arrQueue.dequeue();
        arrQueue.dequeue();
        System.out.println(arrQueue.getFront());
        System.out.println(arrQueue.getRear());


    }
}

class ArrQueue {
    int[] arr;
    int size;
    int capacity;
    int front;
    int rear;

    public ArrQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.front =0;
        this.rear = -1;
        this.arr = new int[capacity];
    }

    void enqueue(int el){
        if(rear == capacity -1){
            throw new RuntimeException("Queue is Full");
        }else{
            rear++;
            arr[rear]=el;
            size++;
        }
    }

    int dequeue(){
        if(front > rear){
            throw new RuntimeException("Queue is empty");
        }
        else{
            int res= arr[front];
            front++;
            size--;
            return res;
        }
    }

    int getFront(){
        if(size>0){
            return arr[front];
        }else{
            throw new RuntimeException("Queue is Empty");
        }
    }

    int getRear(){
        if(size>0){
            return arr[rear];
        }else{
            throw new RuntimeException("Queue is Empty");
        }
    }

    boolean isEmpty(){
        return size == 0;
    }

    boolean isFull(){
        return size == capacity;
    }

    int size(){
        return size;
    }
}