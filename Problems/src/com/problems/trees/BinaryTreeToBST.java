package com.problems.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBST {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        List<Integer> nodeList = new ArrayList<>();

        getAllNodesList(root,nodeList);

        Collections.sort(nodeList);

        int[] index = {0};

       replaceBinaryTreeToBST(nodeList,root,index);

       inorderTraversal(root);
    }

    private static void replaceBinaryTreeToBST(List<Integer> nodeList, Node root, int[] index) {
        if(root == null) return;
        replaceBinaryTreeToBST(nodeList,root.left,index);
        root.key = nodeList.get(index[0]);
        index[0]++;
        replaceBinaryTreeToBST(nodeList,root.right,index);
    }

    private static void getAllNodesList(Node root,List<Integer> nodeList) {
        if(root!=null) {
            getAllNodesList(root.left,nodeList);
            nodeList.add(root.key);
            getAllNodesList(root.right,nodeList);
        }

    }

    private static void inorderTraversal(Node root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.key+" ");
            inorderTraversal(root.right);
        }
    }
}
