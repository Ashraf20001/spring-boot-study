package com.problems.graph;

import java.util.*;

public class TransposeOfAGraph {
    private static int vector = 4;

    private static ArrayList<Integer> [] adj= new ArrayList[vector];
    private static ArrayList<Integer> [] trns= new ArrayList[vector];

    public static void main(String[] args) {
        for (int i = 0; i < vector; i++) {
            adj[i]= new ArrayList<>();
            trns[i]= new ArrayList<>();
        }

        addAdjacent(0,1,false);
        addAdjacent(1,3,false);
        addAdjacent(3,2,false);
        addAdjacent(2,0,false);

        getTranspose();

        printTranspose();
    }

    private static void printTranspose() {
        for (int i = 0; i <vector; i++) {
            System.out.print(i+" :");
            for (int j = 0; j < trns[i].size(); j++) {
                System.out.print(trns[i].get(j)+" ");
            }
        }
    }

    private static void getTranspose() {
        for (int i = 0; i < vector; i++) {
            for(int j=0; j< adj[i].size() ; j++){
                addAdjacent(i,adj[i].get(j),true);
            }
        }
    }

    private static void addAdjacent(int u, int v, boolean isTranspose) {
        if(!isTranspose)
            adj[u].add(v);
        else trns[v].add(u);
    }

}
