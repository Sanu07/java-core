package com.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        int v = 5; // 0 1 2 3 4
        List<List<Integer>> list = new ArrayList<>(5);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        AdjacencyListRep.addEdge(list, 0, 1);
        AdjacencyListRep.addEdge(list, 0, 2);
        AdjacencyListRep.addEdge(list, 1, 2);
        AdjacencyListRep.addEdge(list, 1, 3);
        AdjacencyListRep.addEdge(list, 2, 4);
        AdjacencyListRep.addEdge(list, 3, 4);

        GraphUtil.displayAdjacencyList(list);
        System.out.println("***************************************\n");
        bfs(list, 0);
    }

    public static void bfs(List<List<Integer>> adjacencyList, int src) {
        System.out.println("BFS with src " + src);
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[adjacencyList.size()];

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neighbor: adjacencyList.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
