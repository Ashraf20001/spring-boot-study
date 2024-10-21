package com.problems.trees;

public class BalancedBinaryTreeOrNot {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);

        System.out.println(balancedBinaryTreeOrNot(root) < 0);
    }

    private static int balancedBinaryTreeOrNot(Node root) {
        if(root == null){
            return 0;
        }
        int leftHeight = balancedBinaryTreeOrNot(root.left);
        if(leftHeight==-1){
            return -1;
        }
        int rightHeight = balancedBinaryTreeOrNot(root.right);
        if(rightHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
        }
}
