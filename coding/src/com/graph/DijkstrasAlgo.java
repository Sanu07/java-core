package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

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

        dijkstras(adj);
    }

    private static void dijkstras(ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        boolean[] vis = new boolean[adj.size()];
        int s = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        int[] ans = new int[adj.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);

        q.add(new Pair(s, 0));
        ans[s] = 0;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.vertex;
            if (vis[u]) {
                continue;
            }

            vis[u] = true;

            ArrayList<ArrayList<Integer>> neighbors = adj.get(u);

            for (List<Integer> neighbor: neighbors) {
                int vertex = neighbor.get(0);
                int wt = neighbor.get(1);
                if (ans[u] + wt < ans[vertex]) {
                    ans[vertex] = ans[u] + wt;
                    q.add(new Pair(vertex, ans[vertex]));
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
