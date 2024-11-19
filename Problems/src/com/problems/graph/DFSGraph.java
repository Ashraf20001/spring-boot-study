package com.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSGraph  {
    public static void main(String[] args) {

        int vertices = 5;

        List<List<Integer>> adjElements = new ArrayList<>();

        for(int i=0; i< vertices ; i++){
            adjElements.add(new ArrayList<>());
        }

        int[][] edges = {
                { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

       for (int [] elements: edges){
           addEdges(elements[0],elements[1],adjElements);
       }
       int sourceElement = 1;
       dfs(adjElements,sourceElement,vertices);
    }

    private static void dfs(List<List<Integer>> adjElements, int sourceElement, int vertices) {
        boolean[] visitedArray = new boolean[vertices];
        dfsRec(adjElements,sourceElement,visitedArray);
    }

    private static void dfsRec(List<List<Integer>> adjElements, int sourceElement, boolean[] visitedArray) {
        visitedArray[sourceElement]= true;
        System.out.print(sourceElement+" ");

        for(int i=0;i<adjElements.get(sourceElement).size();i++){          // checking each individual  adjacent elements has its own
           if(!visitedArray[adjElements.get(sourceElement).get(i)]){       //  adjacent elements
                dfsRec(adjElements,adjElements.get(sourceElement).get(i),visitedArray);
            }
        }
    }

    private static void addEdges(int element, int element1, List<List<Integer>> adjElements) {
        adjElements.get(element).add(element1);
        adjElements.get(element1).add(element);
    }

}
