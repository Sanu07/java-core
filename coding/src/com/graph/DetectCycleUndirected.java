package com.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirected {

    public static void main(String[] args) {
        int v = 4; // 0 1 2 3 4
        List<List<Integer>> list = new ArrayList<>(5);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        AdjacencyListRep.addEdge(list, 0, 1);
        AdjacencyListRep.addEdge(list, 1, 2);
        AdjacencyListRep.addEdge(list, 1, 3);
        AdjacencyListRep.addEdge(list, 2, 3);

        GraphUtil.displayAdjacencyList(list);
        System.out.println("***************************************\n");
        System.out.println(detectCycle(list));
        System.out.println("***************************************\n");
        System.out.println(checkForCycleBFS(list, 0));
    }

    private static boolean detectCycle(List<List<Integer>> adjacencyList) {
        boolean[] vis = new boolean[adjacencyList.size()];
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!vis[i]) {
                if (hasCycle(i, adjacencyList, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCycle(int v, List<List<Integer>> adjacencyList, boolean[] vis, int parent) {
        vis[v] = true;
        for (int neighbor: adjacencyList.get(v)) {
            if (!vis[neighbor]) {
                if (hasCycle(neighbor, adjacencyList, vis, v)) {
                    return true;
                }
            } else if (parent != neighbor) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForCycleBFS(List<List<Integer>> adj, int src) {
        Queue<Pair> q = new ArrayDeque<>();
        boolean[] vis = new boolean[adj.size()];

        q.add(new Pair(src, -1));
        vis[src] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curr = p.first;
            int parent = p.second;

            for (int neighbor: adj.get(curr)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(new Pair(neighbor, curr));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
