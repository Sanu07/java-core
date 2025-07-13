package com.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirected {

    public static void main(String[] args) {
        int v = 4; // 0 1 2 3 4
        List<List<Integer>> list = new ArrayList<>(5);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        AdjacencyListRep.addEdgeDirected(list, 1, 0);
        AdjacencyListRep.addEdgeDirected(list, 0, 2);
        AdjacencyListRep.addEdgeDirected(list, 2, 3);
        AdjacencyListRep.addEdgeDirected(list, 3, 0);

        GraphUtil.displayAdjacencyList(list);
        System.out.println("***************************************\n");
        System.out.println(detectCycle(list));
    }

    private static boolean detectCycle(List<List<Integer>> adjacencyList) {
        boolean[] vis = new boolean[adjacencyList.size()];
        boolean[] pathVis = new boolean[adjacencyList.size()];

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!vis[i]) {
                if (hasCycle(i, adjacencyList, vis, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCycle(int v, List<List<Integer>> adjacencyList, boolean[] vis, boolean[] recS) {
        vis[v] = true;
        recS[v] = true;

        for (int neighbor: adjacencyList.get(v)) {
            if (!vis[neighbor]) {
                if (hasCycle(neighbor, adjacencyList, vis, recS)) {
                    return true;
                }
            } else if (recS[neighbor]) {
                return true;
            }
        }
        recS[v] = false;
        return false;
    }

    /* UPDATED */
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[adj.size()];
        boolean[] pathVis = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!vis[i]) {
                if (isCyclic(adj, vis, pathVis, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclic(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis, int src) {
        vis[src] = true;
        pathVis[src] = true;

        for (int neighbor: adj.get(src)) {
            if (!vis[neighbor]) {
                if (isCyclic(adj, vis, pathVis, neighbor)) {
                    return true;
                }
            } else if (pathVis[neighbor]) {
                return true;
            }
        }
        // **** IMP
        pathVis[src] = false;
        return false;
    }
}
