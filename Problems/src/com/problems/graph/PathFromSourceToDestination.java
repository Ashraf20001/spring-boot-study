package com.problems.graph;

import java.util.*;

public class PathFromSourceToDestination {

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
        int s=3;
        int d=4;

        System.out.println(isPathReachable(s, d,adjElements));

    }

    private static boolean isPathReachable(int s, int d, List<List<Integer>> adjElements) {

        boolean[] visitedArray = new boolean[adjElements.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        visitedArray[s] = true;
        queue.add(s);

        while(!queue.isEmpty()){
            Integer element = queue.poll();
            Iterator<Integer> integerListIterator = adjElements.get(element).listIterator();

            while(integerListIterator.hasNext()){
                Integer adjElement = integerListIterator.next();
                if(d == adjElement){
                    return true;
                }
                if(!visitedArray[adjElement]){
                    queue.add(adjElement);
                    visitedArray[adjElement]= true;
                }
            }
        }


        return false;
    }


    private static void addEdges(int element, int element1, List<List<Integer>> adjElements) {
        adjElements.get(element).add(element1);
    }
}
