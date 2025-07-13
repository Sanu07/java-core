package com.graph;

import java.sql.Array;
import java.util.*;

public class TopologicalSortDAGBFS {

    public static void main(String[] args) {
        int v = 6;
        List<List<Integer>> list = new ArrayList<>(5);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        AdjacencyListRep.addEdgeDirected(list, 0, 3);
        AdjacencyListRep.addEdgeDirected(list, 0, 2);
        AdjacencyListRep.addEdgeDirected(list, 2, 1);
        AdjacencyListRep.addEdgeDirected(list, 3, 1);
        AdjacencyListRep.addEdgeDirected(list, 1, 4);
        AdjacencyListRep.addEdgeDirected(list, 5, 1);
        AdjacencyListRep.addEdgeDirected(list, 5, 4);

        GraphUtil.displayAdjacencyList(list);
        System.out.println("***************************************\n");
        topoSortBFS(list); // (0 2 3 5 1 4) | (5 0 2 3 1 4)
    }

    private static void topoSortBFS(List<List<Integer>> list) {
        int[] inDeg = new int[list.size()];

        for (List<Integer> i: list) {
            for (int j: i) {
                inDeg[j] += 1;
            }
        }
        boolean[] vis = new boolean[list.size()];
        List<Integer> ans = new ArrayList<>();

        topoSortBfs(list, vis, 0, ans, inDeg);

        System.out.println(ans);
    }

    private static void topoSortBfs(List<List<Integer>> list, boolean[] vis, int v, List<Integer> ans, int[] inDeg) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(curr);

            for (int neighbor: list.get(curr)) {
                inDeg[neighbor] -= 1;
                if (inDeg[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
    }
}
