package com.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    int front;
    int rear;
    int size;
    List<Node> nodes;

    public Queue(){
        this.front = 0;
        this.rear  = -1;
        this.size = 0;
        this.nodes = new ArrayList<>();
    }

    public void add(Node el){

        if(el != null){
           this.rear ++;
           this.nodes.add(el);
           this.size++;
        }
    }

    public Node poll(){
        if(size == 0){
            return null;
        }else{
            Node temp = this.nodes.get(front);
            this.nodes.remove(temp);
            this.rear--;
            this.size--;
            return temp;
        }
    }


    public Node peekFirst(){
        if(size>0){
            return this.nodes.get(this.front);
        }
        return null;
    }

    public Node peekLast(){
        if(size>0){
            return this.nodes.get(this.rear);
        }
        return null;
    }

    public int getSize(){
        return  this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

}
