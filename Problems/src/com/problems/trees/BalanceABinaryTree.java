package com.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinaryTree {
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(15);
        root.right.right = new Node(20);

        root = balanceTree(root);
        inorderTraversal(root);
    }

    private static void inorderTraversal(Node root) {
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.key+" ");
            inorderTraversal(root.right);
        }
    }

    private static Node balanceTree(Node root) {

        List<Integer> treeElements = new ArrayList<>();

        addSortedElemets (root,treeElements);

        return balanceBinaryTree(0,treeElements.size()-1,treeElements);
    }

    private static Node balanceBinaryTree(int start, int end, List<Integer> treeElements) {
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(treeElements.get(mid));
        root.left = balanceBinaryTree(start,mid-1,treeElements);
        root.right = balanceBinaryTree(mid+1,end,treeElements);
        return root;
    }

    private static void addSortedElemets(Node root, List<Integer> treeElements) {  // With inorder traversal we can get
        if(root != null){                                                         // sorted elements.
            addSortedElemets(root.left,treeElements);
            treeElements.add(root.key);
            addSortedElemets(root.right,treeElements);
        }
    }
}
