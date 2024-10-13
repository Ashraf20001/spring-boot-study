package com.problems.trees;

public class BSTDeletion {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

       root = deleteNode(root,50);

       inorder(root);

    }

    private static Node deleteNode(Node root, int element) {

        if(root == null){
            return root;
        }
        if(root.key < element){
            root.right = deleteNode(root.right,element);  // insertion of modified right node
        }else if(root.key>element){
            root.left =  deleteNode(root.left,element);   // insertion of modified left node
        }else{

            // Either it is leaf node or node with only one child
            if(root.left == null){
                return root.right;
            }

            if(root.right == null){
                return root.left;
            }

            // If it has both child

            Node successor = getSuccessor(root);
            root.key = successor.key;
            root.right = deleteNode(root.right,successor.key);     // since we are getting successor from root's right node
        }                                                          //, for deleting the previous element, we are passing right node.
        return root;
    }

    private static Node getSuccessor(Node curr) {
        curr = curr.right;  // Successor must always be greater element than root element
        while(curr != null && curr.left != null){     // If we traverse over right side element alone, We could get very
           curr = curr.left;                          // greater successor. If we traverse from left position of root's right, we can get nearest
        }                                             // successor of root element
        return curr;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}
