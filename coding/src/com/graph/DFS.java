package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        int v = 5; // 0 1 2 3 4
        List<List<Integer>> list = new ArrayList<>(5);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        AdjacencyListRep.addEdge(list, 0, 1);
        AdjacencyListRep.addEdge(list, 0, 2);
        AdjacencyListRep.addEdge(list, 1, 2);
        AdjacencyListRep.addEdge(list, 2, 3);
        AdjacencyListRep.addEdge(list, 2, 4);

        GraphUtil.displayAdjacencyList(list);
        System.out.println("***************************************\n");
        dfs(list, 1);
    }

    private static void dfs(List<List<Integer>> list, int src) {
        System.out.println("DFS with src " + src);
        boolean[] visited = new boolean[list.size()];
        dfs2(list, visited, src);
    }

    private static void dfs(List<List<Integer>> list, boolean[] visited, int src) {
        visited[src] = true;
        System.out.print(src + " ");
        for (int neighbor: list.get(src)) {
            if (!visited[neighbor]) {
                dfs(list, visited, neighbor);
            }
        }
    }

    private static void dfs2(List<List<Integer>> list, boolean[] visited, int src) {
        visited[src] = true;
        System.out.println("src -->> " + src + " ");
        System.out.println("visited -->> " + Arrays.toString(visited));
        for (int neighbor: list.get(src)) {
            if (!visited[neighbor]) {
                dfs2(list, visited, neighbor);
            }
        }
    }
}
