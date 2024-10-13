package com.problems.trees;


import java.util.LinkedList;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.left.left = new Node(30);
//        root.left.left.left = new Node(6);
//        root.left.left.left.left = new Node(7);
//        root.left.left.left.right = new Node(8);
        root.left.right = new Node(50);
        root.right = new Node(60);
        root.right.left = new Node(80);
        root.right.right = new Node(90);
//        printLevelOrderTree(root);
//        printLevelOrderLineByLine(root);
//        printLevelOrderLineByLineRightToLeft(root);
        printLeftViewOrderLineByLine(root);
        printRightViewOrderLineByLine(root);
    }


    private static void printLevelOrderTree(Node root) {
            Queue queue = new Queue();
            if(root!=null){
                queue.add(root);

                while(queue.size>0){
                    Node current = queue.poll();
                    System.out.println(current.key);
                    if(current.left != null){
                        queue.add(current.left);
                    }if(current.right !=null){
                        queue.add(current.right);
                    }
                }
            }
    }

    private static void printLevelOrderTreeRightToLeft(Node root) {
            Queue queue = new Queue();
            if(root!=null){
                queue.add(root);

                while(queue.size>0){
                    Node current = queue.poll();
                    System.out.println(current.key);
                    if(current.left != null){
                        queue.add(current.right);
                    }if(current.right !=null){
                        queue.add(current.left);
                    }
                }
            }
    }

    private  static void printLevelOrderLineByLine(Node root){
              java.util.Queue<Node> queue = new LinkedList<>();
              if(root!=null){
                  queue.add(root);
                  while(queue.size()>0){
                      int count = queue.size();
                      for (int i=0;i<count;i++){
                          Node temp = queue.poll();
                          System.out.print(temp.key+" ");
                          if(temp.left != null){
                              queue.add(temp.left);
                          }
                          if(temp.right != null){
                              queue.add(temp.right);
                          }
                      }
                      System.out.println();

                  }
              }
    }

    private  static void printLevelOrderLineByLineRightToLeft(Node root){
              java.util.Queue<Node> queue = new LinkedList<>();
              if(root!=null){
                  queue.add(root);
                  while(queue.size()>0){
                      int count = queue.size();
                      for (int i=0;i<count;i++){
                          Node temp = queue.poll();
                          System.out.print(temp.key+" ");
                          if(temp.left != null){
                              queue.add(temp.right);
                          }
                          if(temp.right != null){
                              queue.add(temp.left);
                          }
                      }
                      System.out.println();

                  }
              }
    }

    private  static void printLeftViewOrderLineByLine(Node root){
        java.util.Queue<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
            while(queue.size()>0){
                int count = queue.size();
                for (int i=0;i<count;i++){
                    Node temp = queue.poll();
                    if(i==0){
                        System.out.print(temp.key + " ");
                    }
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }

            }
        }
    }

    private  static void printRightViewOrderLineByLine(Node root){
        java.util.Queue<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
            while(queue.size()>0){
                int count = queue.size();
                for (int i=0;i<count;i++){
                    Node temp = queue.poll();
                    if(i==count-1){
                        System.out.print(temp.key + " ");
                    }
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }

            }
        }
    }
}

