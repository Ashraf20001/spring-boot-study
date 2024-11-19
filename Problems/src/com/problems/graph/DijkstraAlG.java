package com.problems.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlG {
    public static void main(String[] args) {
        int v = 9;
        int [][] edges ={
                {0, 1, 4},
                {0, 7, 8},
                {1, 2, 8},
                {1, 7, 11},
                {2, 3, 7},
                {2, 8, 2},
                {2, 5, 4},
                {3, 4, 9},
                {3, 5, 14},
                {4, 5, 10},
                {5, 6, 2},
                {6, 7, 1},
                {6, 8, 6},
                {7, 8, 7}
        };

        List<List<Pair>> nodeDistanceGraph = new ArrayList<>();

        nodeDistanceGraph = addAdjPairs(nodeDistanceGraph,edges,v);

        int[] distance = dijksAlg(nodeDistanceGraph, v);

        for (int i=0 ; i< v ; i++){
            System.out.println(i+" shorter distance is "+distance[i]);
        }

    }

    private static int[] dijksAlg(List<List<Pair>> nodeDistanceGraph, int v) {
        int[] distance = new int[v];

        for (int i = 0; i <distance.length; i++) {
            distance[i]= Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> shortDistancePriorityQueue = new PriorityQueue<>(v, Comparator.comparingInt(el -> el.distance));

        int source = 0;
        shortDistancePriorityQueue.add(new Pair(source,0));
        distance[source] = 0;

        while(!shortDistancePriorityQueue.isEmpty()){
            Pair element = shortDistancePriorityQueue.poll();
            for (int i=0; i<nodeDistanceGraph.get(element.node).size(); i++){
                int adjacentDistance = nodeDistanceGraph.get(element.node).get(i).distance;
                if(distance[nodeDistanceGraph.get(element.node).get(i).node]> distance[element.node] + adjacentDistance){
                    distance[nodeDistanceGraph.get(element.node).get(i).node] = distance[element.node] + adjacentDistance;
                    shortDistancePriorityQueue.add(new Pair(nodeDistanceGraph.get(element.node).get(i).node, distance[nodeDistanceGraph.get(element.node).get(i).node]));
                }
            }

        }
        return distance;
    }

    private static List<List<Pair>> addAdjPairs(List<List<Pair>> nodeDistanceGraph, int[][] edges, int v) {

        for (int i = 0; i < v; i++) {
            nodeDistanceGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            nodeDistanceGraph.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            nodeDistanceGraph.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        return nodeDistanceGraph;
    }
}

class Pair {
    int node;
    int distance;

    public  Pair(int node,int distance){
        this.node = node;
        this.distance = distance;
    }
}
