package com.graph;

import java.util.*;

public class KruskalsAlgo {

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

        kruskals(adj, 5);
    }

    static int[] p, rank;

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) {
            return;
        }
        p[ry] = rx;
    }

    static void unionByRank(int x, int y) {
        int xRoot = findByPathCompression(x);
        int yRoot = findByPathCompression(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            p[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            p[yRoot] = xRoot;
        } else {
            p[yRoot] = xRoot;
            rank[xRoot] += 1;
        }
    }

    static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return find(p[x]);
    }

    static int findByPathCompression(int x) {
        if (p[x] != x) {
            p[x] = find(x);
        }
        return p[x];
    }

    private static void kruskals(ArrayList<ArrayList<ArrayList<Integer>>> adj, int v) {

        rank = new int[v];

        boolean[][] added = new boolean[v][v];
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                List<Integer> curr = adj.get(i).get(j);
                if (!added[i][curr.get(0)]) {
                    added[i][curr.get(0)] = true;
                    added[curr.get(0)][i] = true;
                    edges.add(new Edge(i, curr.get(0), curr.get(1)));
                }
            }
        }

        p = new int[v];


        for (int i = 0; i < v; i++) {
            // initializing the parent array
            p[i] = i;
        }

        Collections.sort(edges);
        int count = 1;
        int ans = 0;

        for (int i = 0; count < v; i++) {
            Edge edge = edges.get(i);
            int rx = find(edge.src);
            int ry = find(edge.dest);
            if (rx != ry) {
                union(rx, ry);
                count++;
                ans += edge.wt;
            }
        }

        System.out.println(ans);
    }
}
