package com.problems.trees;

public class DepthFirstTraversal {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.left.left = new Node(30);
        root.left.right = new Node(50);
        root.right = new Node(60);
        root.right.left = new Node(80);
        root.right.right = new Node(90);

//        Node root = new Node(10);
//        root.left=new Node(20);
//        root.left.left= new Node(25);
//        root.right = new Node(30);
//        root.right.left = new Node(45);
//        root.right.left.right = new Node(65);

//        printTreeWithInorderDepthFist(root);     // left-> root -> right
//        printTreeWithPreorderDepthFirst(root);
//        printTreeWithPostorderDepthFirst(root);
//          System.out.println(findHeightOfTheTree(root));
//          printNodesAtDistanceK(root,2);
         System.out.println(findSizeOfTheTree(root));
//         System.out.println(findMaximumElementOfTheTree(root));
    }

    private static void printTreeWithInorderDepthFist(Node root) {
        if(root!=null){
            printTreeWithInorderDepthFist(root.left);
            System.out.println(root.key);
            printTreeWithInorderDepthFist(root.right);
        }
    }

    private static void printTreeWithPreorderDepthFirst(Node root){
        if(root!=null){
            System.out.println(root.key);
            printTreeWithPreorderDepthFirst(root.left);
            printTreeWithPreorderDepthFirst(root.right);
        }

    }

    private static int findHeightOfTheTree(Node root){
        if(root == null){
            return 0;
        }else{
            int leftHeight = findHeightOfTheTree(root.left);
            int rightHeight = findHeightOfTheTree(root.right);
            return Math.max(leftHeight,rightHeight) +1;
        }
    }

    private static void printTreeWithPostorderDepthFirst(Node root){
        if(root!=null){
            printTreeWithPostorderDepthFirst(root.left);
            printTreeWithPostorderDepthFirst(root.right);
            System.out.println(root.key);
        }

    }

    private static void printNodesAtDistanceK(Node root, int k) {
       if(root!=null){
           if (k == 0) {

               System.out.println(root.key);
           } else {
               k = k - 1;
               printNodesAtDistanceK(root.right, k);
               printNodesAtDistanceK(root.left, k);
           }
       }

    }

    private static int findSizeOfTheTree(Node root){
        if(root == null){
            return 0;
        }else{
            int leftNodesSize = findSizeOfTheTree(root.left);
            int rightNodesSize = findSizeOfTheTree(root.right);
            return leftNodesSize+rightNodesSize +1;
        }
    }

    private static int findMaximumElementOfTheTree(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }else{
            int leftNodesMaximumElement = findMaximumElementOfTheTree(root.left);
            int rightNodesMaximumElement = findMaximumElementOfTheTree(root.right);
            return Math.max(root.key,Math.max(leftNodesMaximumElement,rightNodesMaximumElement));
        }
    }
}
