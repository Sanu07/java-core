package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDAGDFS {

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
        topoSortDFS(list); // (0 2 3 5 1 4) | (5 0 2 3 1 4)
    }

    private static void topoSortDFS(List<List<Integer>> list) {
        boolean[] vis = new boolean[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            if (!vis[i]) {
                topoSort(list, i, stack, vis);
            }
        }
        int i = 0;
        int[] ans = new int[stack.size()];
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        System.out.println(Arrays.toString(ans));
    }

    private static void topoSort(List<List<Integer>> list, int v, Stack<Integer> stack, boolean[] vis) {
        vis[v] = true;
        for (int neighbor: list.get(v)) {
            if (!vis[neighbor]) {
                topoSort(list, neighbor, stack, vis);
            }
        }
        stack.push(v);
    }


}
