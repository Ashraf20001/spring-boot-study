package com.problems.trees;

public class SimpleHardCodedTree {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.left.left = new Node(30);
        root.left.right = new Node(50);
        root.right = new Node(60);
        root.right.left = new Node(80);
        root.right.right = new Node(90);

    }
}

class Node{
    Node left;
    Node right;
    int key;
    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}