package com.graph.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Traversal {

    public static void main(String[] args) {
        // bfs();
        // dfs();
        detectCycleUndirectedBfs();
    }

    public static void bfs() {
        List<List<Integer>> adjList = GraphUtil.getUndirectedGraph();
        int src = 1;
        boolean[] vis = new boolean[adjList.size()];

        for (int i = 1; i < adjList.size(); i++) {
            if (!vis[i]) {
                bfs(adjList, vis, i);
            }
        }
    }

    public static void bfs(List<List<Integer>> adjList, boolean[] vis, int src) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.println(curr + " ");

            for (int neighbor: adjList.get(curr)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void dfs() {
        List<List<Integer>> adjList = GraphUtil.getUndirectedGraph();
        int src = 1;

        boolean[] vis = new boolean[adjList.size()];
        for (int i = 1; i < adjList.size(); i++) {
            if (!vis[i]) {
                dfs(adjList, vis, i);
            }
        }

    }

    private static void dfs(List<List<Integer>> adjList, boolean[] vis, int src) {
        System.out.println(src + " ");
        vis[src] = true;
        for (int neighbor: adjList.get(src)) {
            if (!vis[neighbor]) {
                dfs(adjList, vis, neighbor);
            }
        }
    }

    private static void detectCycleUndirectedBfs() {

        List<List<Integer>> adjList = GraphUtil.getUndirectedGraph();
        boolean[] vis = new boolean[adjList.size()];

        boolean hasCycle = false;

        for (int i = 1; i < adjList.size(); i++) {
            if (!vis[i]) {
                if (detectCycleUndirectedBfs(adjList, vis, i)) {
                    hasCycle = true;
                    break;
                }
            }
        }
        System.out.println(hasCycle);
    }

    private static boolean detectCycleUndirectedBfs(List<List<Integer>> adjList, boolean[] vis, int src) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.vertex;
            int parent = curr.parent;

            for (int neighbor: adjList.get(u)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(new Pair(neighbor, u));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }


    public static class Pair {
        int vertex;
        int parent;

        public Pair(int vertex, int parent) {
            this.vertex = vertex;
            this.parent = parent;
        }
    }
}
