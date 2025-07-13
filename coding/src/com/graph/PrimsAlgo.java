package com.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
        System.out.println(adj);

        spanningTree(adj);
    }

    private static void spanningTree(ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        boolean[] vis = new boolean[adj.size()];

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        pq.add(new Pair(0, 0));
        int ans = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.vertex;
            if (vis[u]) {
                continue;
            }
            ans += curr.weight;
            vis[u] = true;

            ArrayList<ArrayList<Integer>> neighbors = adj.get(u);

            for (List<Integer> neighbor: neighbors) {
                int vertex = neighbor.get(0);
                int wt = neighbor.get(1);
                if (!vis[vertex]) {
                    pq.add(new Pair(vertex, wt));
                }
            }
        }
        System.out.println(ans);
    }
}
