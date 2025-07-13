package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BellmanFordAlgo {

    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<>(Arrays.asList(2, 4, 3)));
            }
        };

        System.out.println(edges);

        bellmanFord(edges, V);
    }

    private static void bellmanFord(ArrayList<ArrayList<Integer>> adj, int noOfVertices) {
        int s = 0;
        int[] dist = new int[noOfVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for (int i = 0; i < adj.size() - 1; i++) {
            for (List<Integer> curr: adj) {
                int u = curr.get(0);
                int v = curr.get(1);
                int wt = curr.get(2);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (List<Integer> curr: adj) {
            int u = curr.get(0);
            int v = curr.get(1);
            int wt = curr.get(2);
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                Arrays.fill(dist, -1);
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
