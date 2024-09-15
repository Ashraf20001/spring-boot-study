package com.problems.queues;

public class Number56Series {
    public static void main(String[] args) {
        Integer n =12;
        print56NumberSeries(n);
    }

    private static void print56NumberSeries(Integer n) {
        QueueWithLinkedList queueWithLinkedList = new QueueWithLinkedList();
        queueWithLinkedList.enqueue(5);
        queueWithLinkedList.enqueue(6);
        for (int i=0; i<n;i++){
            String temp=String.valueOf(queueWithLinkedList.dequeue());
            System.out.println(temp);
            queueWithLinkedList.enqueue(Integer.parseInt(temp+"5"));
            queueWithLinkedList.enqueue(Integer.parseInt(temp+"6"));
        }
    }
}

