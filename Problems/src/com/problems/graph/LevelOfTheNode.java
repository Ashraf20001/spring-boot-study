package com.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOfTheNode {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges
                = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
        int X = 3;

        int level = findLevel(V, edges, X);
        System.out.println(level);
    }

    private static int findLevel(int v, int[][] edges, int x) {
        int maxVertex = 0;

        for(int i[] : edges){    // Find maxVertex for creating and defining the list of vertices
            maxVertex = Math.max(maxVertex,Math.max(i[0],i[1]));
        }

        List<Integer>[] adj = new ArrayList[maxVertex + 1];

        for (int i = 0; i < adj.length; i++) {   // assigning default value for List
            adj[i]= new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {     // From edges matrix , assign its value to the adj list
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        if( x > maxVertex || adj[x].isEmpty()){
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visitedArray = new boolean[maxVertex+1];

        int level = 0;

        queue.add(0);
        visitedArray[0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size -- > 0){
                Integer graphNode = queue.poll();
                if(x == graphNode){
                    return level;
                }

                for(Integer el : adj[graphNode]){
                    if(!visitedArray[el]){
                        queue.add(el);
                        visitedArray[el] = true;
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
