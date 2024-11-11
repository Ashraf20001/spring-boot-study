package com.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

    private  static  int vertices = 5;
    public static void main(String[] args) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <vertices+1;i++) {
            adj.add(new ArrayList<>());      // vertices+1 is for the vertex which value is equal to the number of vertices.
        }


        addAdj(adj,0,1);
        addAdj(adj,1,3);
        addAdj(adj,3,4);
        addAdj(adj,4,2);
        addAdj(adj,2,1);

        bfs(adj,0);
    }

    private static void bfs(List<List<Integer>> adj,int start) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visitedArray = new boolean[vertices];

        queue.add(start);
        visitedArray[start] = true;
        while(!queue.isEmpty()){
            Integer graphNode = queue.poll();
            System.out.println(graphNode+" ");

            for (int i = 0; i < adj.get(graphNode).size(); i++) {
                if(!visitedArray[adj.get(graphNode).get(i)]){
                    queue.add(adj.get(graphNode).get(i));
                    visitedArray[adj.get(graphNode).get(i)]= true;
                }
            }
        }
    }

    private static void addAdj(List<List<Integer>> adj, int u, int v) {
            adj.get(u).add(v);
    }
}
