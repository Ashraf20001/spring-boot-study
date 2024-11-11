package com.problems.graph;

import java.util.ArrayList;
import java.util.List;

public class BFSWithoutQueue {
    public static void main(String[] args) {
        int vertices = 4;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <vertices+1; i++) {
            adj.add(new ArrayList<>());
        }


        addAdj(adj,0,1);
        addAdj(adj,1,3);
        addAdj(adj,3,4);
        addAdj(adj,4,2);
        addAdj(adj,2,1);

        bfsWithoutQueue(adj,2,vertices);

    }

    private static void bfsWithoutQueue(List<List<Integer>> adj, int start, int vertices) {
        boolean[] visitedArray = new boolean[adj.size()];
        List<Integer> nodeElements = new ArrayList<>();

        int current = 0;

        nodeElements.add(start);
        visitedArray[start]= true;

        while(current < vertices){
            Integer element = nodeElements.get(current);
            System.out.print(element+" ");
            for(int i=0; i<adj.get(element).size(); i++){
                if(!visitedArray[adj.get(element).get(i)]){
                    nodeElements.add(adj.get(element).get(i));
                    visitedArray[adj.get(element).get(i)]= true;
                }
            }
            current++;
        }
    }

    private static void addAdj(List<List<Integer>> adj, int u, int v) {
            adj.get(u).add(v);
    }
}
