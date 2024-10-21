package com.problems.trees;

public class BSTorNot {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(isBST(root));
    }

    private static boolean isBST(Node root) {

        int[] prev = {Integer.MIN_VALUE};

        while(root!=null){
            if(root.left ==  null){
                if(root.key <= prev[0]){
                    return false;
                }
                prev[0] = root.key;
                root = root.right;
            }else{
                Node previous = root.left;
                while(previous.right!=null && previous.right!=root){
                    previous = previous.right;
                }

                if(previous.right == null){
                    previous.right = root;
                    root=root.left;
                }else{
                    previous.right = null;
                    if(root.key <= prev[0]){
                        return false;
                    }
                    prev[0] = root.key;
                    root= root.right;
                }
            }
        }
        return true;
    }
}
