package com.problems.queues;

public class CircularQueueImplementation {
    public static void main(String[] args) {

        CircularArrQueue arrQueue = new CircularArrQueue(5);
        arrQueue.enqueue(10);
        arrQueue.enqueue(20);
        arrQueue.enqueue(30);
        arrQueue.enqueue(40);
        arrQueue.enqueue(50);
        arrQueue.dequeue();
        arrQueue.dequeue();
        arrQueue.enqueue(60);
        arrQueue.enqueue(70);
        System.out.println(arrQueue.getFront());
        System.out.println(arrQueue.getRear());


    }
}

class CircularArrQueue {
    int[] arr;
    int size;
    int capacity;
    int front;
    int rear;

    public CircularArrQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.front =0;
        this.rear = -1;
        this.arr = new int[capacity];
    }

    void enqueue(int el){
        if(size == capacity){
            throw new RuntimeException("Queue is Full");
        }else{
            rear = (rear +1) % capacity;
            arr[rear]=el;
            size++;
        }
    }

    int dequeue(){
        if(size == 0){
            throw new RuntimeException("Queue is empty");
        }
        else{
            int res= arr[front];
            front = ( front + 1 ) % capacity;
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