package com.problems.graph;

import java.util.ArrayList;
import java.util.List;

public class SimpleGraph {
    public static void main(String[] args) {
       List<List<Integer>>  listOfGraph = new ArrayList<>();

       int vertices = 4;

        for (int i = 0; i < vertices; i++) {   // ASSIGNING DEFAULT VALUES TO THE LIST
            listOfGraph.add(new ArrayList<>());
        }

        addEdgesToTheVertices(listOfGraph,0,1);
        addEdgesToTheVertices(listOfGraph,0,2);
        addEdgesToTheVertices(listOfGraph,2,3);
        addEdgesToTheVertices(listOfGraph,1,2);

        displayAdjList(listOfGraph);
    }

    private static void addEdgesToTheVertices(List<List<Integer>> listOfGraph, int fromVertex, int toVertex) {
        listOfGraph.get(fromVertex).add(toVertex);
//        listOfGraph.get(toVertex).add(fromVertex);
    }

    public static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": "); // Print the vertex
            for (int j : adj.get(i)) {
                System.out.print(j + " "); // Print its adjacent
            }
            System.out.println();
        }
    }
}
