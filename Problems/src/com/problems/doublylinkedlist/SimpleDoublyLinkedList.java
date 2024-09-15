package com.problems.doublylinkedlist;

public class SimpleDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(10);
        doublyLinkedList.add(20);
        doublyLinkedList.add(30);

//        doublyLinkedList.printReverseDoublyLinkedList();
        doublyLinkedList.addFirst(40);
        doublyLinkedList.add(50,3);
        doublyLinkedList.printDoublyLinkedList();
//        doublyLinkedList.removeFirst();
//        doublyLinkedList.removeLast();
        System.out.println("GUIFOYO");
//        doublyLinkedList.printDoublyLinkedList();

    }
}

class Node{
    Node previous;
    Node next;
    int data;

    public Node(){

    }
    public Node(int data){
        this.data=data;
        this.previous=null;
        this.next=null;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;

    public DoublyLinkedList(){

    }

    public DoublyLinkedList(Node head, Node tail){
        this.head =head;
        this.tail = tail;
    }

    void add(int el){
        Node newNodeToBeAdded =new Node(el);
        if(head == null){
            head = newNodeToBeAdded;
            tail = newNodeToBeAdded;
        } else{
            tail.next = newNodeToBeAdded;
            newNodeToBeAdded.previous = tail;
            tail = newNodeToBeAdded;
        }
    }

    void printDoublyLinkedList(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    void printReverseDoublyLinkedList(){
        Node current = tail;
        while(current!=null){
            System.out.println(current.data);
            current = current.previous;
        }
    }

    void addFirst(int el){
        Node nodeToBeAdded = new Node(el);
        if(head == null){
            head = nodeToBeAdded;
            tail = nodeToBeAdded;
        }
        nodeToBeAdded.next = head;
        head.previous=nodeToBeAdded;
        head = nodeToBeAdded;
    }

    void add(int el, int index) throws IndexOutOfBoundsException{
        Node nodeToBeAdded = new Node(el);
        try {
            if(index==0){
                addFirst(el);
            }else{
                Node current = head;
                for(int i=1;i<index;i++){
                    current=current.next;
                }
                current.next.previous = nodeToBeAdded;
                nodeToBeAdded.next= current.next;
                nodeToBeAdded.previous=current;
                current.next=nodeToBeAdded;
            }
        }catch (IndexOutOfBoundsException e){                       // If index is out of range, it will throw array index out of bound exception
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    void addAll(int[] dataList){
        for(int el:dataList){
            add(el);
        }
    }

    void removeFirst(){

        if(head == null){
        } else if(head.next == null){
            head = null;
            tail = null;
        } else{
        Node secondElement=head.next;
        secondElement.previous = null;
        head.next = null;
        head= secondElement;
        }

    }

    void removeLast(){
        if(head == null){
        }else if(head.next == null){
            head = null;
            tail = null;
        } else {
            Node secondLast=tail.previous;
            secondLast.next = null;
            tail.previous = null;
            tail =secondLast;
        }
    }
}
