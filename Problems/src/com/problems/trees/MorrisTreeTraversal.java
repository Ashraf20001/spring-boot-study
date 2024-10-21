package com.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTreeTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        List<Integer> inorderTraversalList = getInorderListFromMorrisTraversal(root);
        for (Integer element: inorderTraversalList){
            System.out.print(element+" ");
        }
    }

    private static List<Integer> getInorderListFromMorrisTraversal(Node root) {

        List<Integer> integerList = new ArrayList<>();
        while(root!= null){
           if(root.left== null){      // root does not have left child
               integerList.add(root.key);
               root = root.right;
           }else{

               Node prev = root.left;    // assigning the root node's left subtree reference to prev node
               while( prev.right != null && prev.right!= root){   // Iterating to the right most node of the left subtree
                   prev = prev.right;
               }

               if(prev.right == null){           // If there is no link to root node
                   prev.right = root;
                   root = root.left;
               } else{
                   prev.right = null;           // If there is link to the root node
                   integerList.add(root.key);
                   root = root.right;
               }
           }
       }

        return integerList;
    }
}
