package com.problems.circularlinkedlist;

public class SimpleCircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);

        circularLinkedList.addFirst(13);
        circularLinkedList.addLast(15);
//        circularLinkedList.removeFirst();
        circularLinkedList.removeLast();
        circularLinkedList.print();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "data= " + data + " , " + "nextRef= " + next;
    }
}

class CircularLinkedList {
    Node head;

    public CircularLinkedList(Node head) {
        this.head = head;
    }
    public CircularLinkedList(){

    }

    void add(int el) {
        Node nodeOfElementToBeAdded = new Node(el);
        if (head == null) {
            head = nodeOfElementToBeAdded;
            nodeOfElementToBeAdded.next = head;
        } else {
            Node current = head.next;
            while (current.next != head) {
                current = current.next;
            }
            current.next = nodeOfElementToBeAdded;
            nodeOfElementToBeAdded.next = head;

        }
    }

    void print() {
        if (head != null) {
            Node current = head;
            System.out.println(head.data);
            current = current.next;
            while (current != head) {
                System.out.println(current.data);
                current = current.next;
            }

        }
    }

    void addFirst(int el){
        Node newNode = new Node(el);
        if(head==null){
            head = newNode;
            head.next = head;
        }
        else{
//            Node current = head;
//            while(current.next!=head){
//                current = current.next;
//            }
//            current.next = newNode;
//            newNode.next = head;
//            head = newNode;
            Node current = head;
            newNode.next= current.next;
            current.next = newNode;

            int temp = current.data;
            current.data = newNode.data;
            newNode.data = temp;
        }
    }

    void addLast(int el){
        Node newNode = new Node(el);
        if(head==null){
            head = newNode;
            head.next = head;
        }
        else{
//            Node current = head;
//            while(current.next!=head){
//                current = current.next;
//            }
//            current.next = newNode;
//            newNode.next = head;

            Node current = head;
            newNode.next= current.next;
            current.next = newNode;

            int temp = current.data;
            current.data = newNode.data;
            newNode.data = temp;

            head = newNode;        // Here reference plays the key role.
        }
    }
    void removeFirst () {
        if (head == null) {

        }
        else if(head.next == head){
            head =null;
        } else{
            Node current = head;

            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;

            current.next = current.next.next;
        }
    }

    void removeLast () {
        if(head == null){

        } else if(head.next==head){
            head = null;
        } else {
            Node current = head;
            while(current.next.next != head){
                current = current.next;
            }
            current.next = head;
        }
    }
}