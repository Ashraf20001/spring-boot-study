package com.problems.trees;

public class BSTInsertion {
    public static void main(String[] args) {
        Node root = null;

        // Creating the following BST
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);
        dfInorderTraversal(root);
    }

    private static void dfInorderTraversal(Node root) {
        if(root!=null){
            dfInorderTraversal(root.left);
            System.out.println(root.key);
            dfInorderTraversal(root.right);
        }
    }

    private static Node insert(Node root, int element) {
        if(root == null){              // new Node creation and insertion
            return new Node(element);
        }

        if(root.key == element){
            return root;
        }

        else if (root.key > element){
            root.left = insert(root.left,element);
        }else{
            root.right = insert(root.right, element);
        }
        return root;
    }
}
