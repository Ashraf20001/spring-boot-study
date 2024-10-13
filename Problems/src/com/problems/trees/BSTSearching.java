package com.problems.trees;

public class BSTSearching {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        searchElement(root,90);

    }

    private static void searchElement(Node root, int element) {

        if(root==null){
            return;
        }

        if(root.key == element){
            System.out.println(element);
        } else if(element<root.key){
            searchElement(root.left,element);
        }else{
            searchElement(root.right,element);
        }
    }
}
