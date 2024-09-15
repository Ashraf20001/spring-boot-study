package com.problems.linkedlist;

public class SimpleLinkedList {

    public static void main(String[] args) {
//        Node p1= new Node(10);
//        Node p2 = new Node(20);
//        Node p3= new Node(30);
//        Node p4 = new Node(40);
//
//        p1.next = p2;
//        p2.next = p3;
//        p3.next = p4;
//
//        Node head = p1;
//        LinkedList linkedList = new LinkedList(head);
//        linkedList.printNodes();

        LinkedList linkedList = new LinkedList();
//        linkedList.add(10);
//        linkedList.add(20);
//        linkedList.add(30);
//        linkedList.add(40);
//        linkedList.addFirst(50);
//
//        linkedList.add(4,60);

        linkedList.addAll(new int[]{10,20,30,40,50});
//        linkedList.removeLast();
//        linkedList.printNodes();
//        System.out.println(linkedList.indexOf(4));
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.lastIndexOf(3));
//        linkedList.printReverse();
//            linkedList.reverseLinkedListUsingLeftAndRight();
        linkedList.sortedLinkedList(55);
        linkedList.printNodes();
    }


}


class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }

    @Override
    public String toString() {
        return "data= "+data + " , " +"nextRef= "+next;
    }
}

class LinkedList{
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList(){

    }

    void printNodes(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    void add(int e){
        Node newNode = new Node(e);
        if(head ==null) {
            head = newNode;
        } else{
           Node currentNode = head;
           while(currentNode.next !=null){              // Looping till getting last node
               currentNode = currentNode.next;
           }
           currentNode.next = newNode;                  // Assigning new node to last node
        }
    }

    void addFirst(int e){
        Node elementToAddFirst = new Node(e);
        if(head == null){
            head = elementToAddFirst;
        } else {
            elementToAddFirst.next = head;             // new element next reference is the  reference of old element
            head = elementToAddFirst;
        }
    }

    void add(int index, int e) throws IndexOutOfBoundsException{
            try {
                Node elementToAdd = new Node(e);
                Node temp=head;
                for(int i=1; i<index ; i++){
                    temp = temp.next;
                }

                if(index==0){
                    addFirst(e);
                } else{
                    elementToAdd.next = temp.next;
                    temp.next = elementToAdd;
                }
            }catch(Exception exception){
                throw new IndexOutOfBoundsException(exception.getMessage());
            }
    }

    void addAll(int[] arr){
            for (int el: arr){
                add(el);
            }
    }

    void removeFirst(){
        if(head==null){
            return;
        }
        head=head.next;
    }

    void removeLast() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;

        }
    }

    int indexOf(int el){
        if(head == null){
            return -1;
        }else if(head.data == el){
            return 0;
        }else{
            int count=1;
            Node current = head.next;
            while(current !=null){
                if(current.data == el){
                    return count;
                }
                current=current.next;
                count++;
            }
        }
        return -1;
    }

    int size(){
        int count =0;
        Node current = head;
        while(current!=null){
            current=current.next;
            count++;
        }
        return count;
    }

    int lastIndexOf(int el) {
        int count = 0;
        int lastIndex = -1;
        Node current = head;
        while (current != null) {
            if (current.data == el) {
                lastIndex = count;
            }
            current = current.next;
            count++;
        }
        return lastIndex;
    }

    void printReverse(){
        Node current=head;
        head=recursivePrintBackwards(current);
        printNodes();
    }

    private  Node recursivePrintBackwards(Node current) {

//        if(current ==null || current.next==null){
//            return current;
//        }
//        Node p =recursivePrintBackwards(current.next);
//        current.next.next = current;
//        current.next=null;
//        return p;

        Node prev=null,curr=head,next=null;
        if(curr == null){
            return head;
        }

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    void reverseLinkedListUsingLeftAndRight(){
        int left=2;
        int right=4;
        Node currentNode = head;
       head = reverseLinkedList(left,right,currentNode);
       printNodes();
    }

    private Node reverseLinkedList(int left, int right, Node currentNode) {
        Node dummy = new Node(-1);
        dummy.next = currentNode;
        Node it = dummy;
        Node previousIt = null;

        for(int i=0;i<left;i++){
            previousIt = it;
            it=it.next;
        }

        Node previousItr = previousIt;
        Node itR = it;

        for(int i = left ; i<=right;i++){
            Node forward = itR.next;
            itR.next = previousItr;
            previousItr = itR;
            itR= forward;
        }
        previousIt.next = previousItr;
        it.next =itR;
        return dummy.next;
    }

    void sortedLinkedList(int el){
            Node nodeToBeAdded = new Node(el);
        if(head == null){
            head = nodeToBeAdded;
        } else if(head.data > nodeToBeAdded.data){
            nodeToBeAdded.next = head;
            head = nodeToBeAdded;
        } else {
            Node current =head.next;
            while(current.next != null && current.next.data < nodeToBeAdded.data){
                current = current.next;
            }
            nodeToBeAdded.next = current.next;
            current.next= nodeToBeAdded;
        }
    }



}