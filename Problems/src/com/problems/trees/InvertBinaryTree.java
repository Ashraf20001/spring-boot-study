package com.problems.trees;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val,TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        invertTree(treeNode);
        printTreeInOrder(treeNode);
    }

    private static void printTreeInOrder(TreeNode treeNode) {
        if(treeNode != null){
            printTreeInOrder(treeNode.left);
            System.out.println(treeNode.val);
            printTreeInOrder(treeNode.right);
        }
    }

    public  static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        invert(root);
        return root;
    }
    public static void invert(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }
}
