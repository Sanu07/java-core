package com.practice;

import com.graph.AdjacencyListRep;
import com.graph.GraphUtil;

import java.util.*;

public class Graph1 {

    public static void main(String[] args) {

        // bfs();
        // dfs();

        // topoLogicalSortDFS();
        // topoLogicalSortBFS();
        // prims();
        // dijkstras();
        bellmanFord();
    }

    private static void bellmanFord() {
        int V = 5;
        int[][] edges = new int[][] {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };

        int src = 0;

        int[] dist = new int[edges.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V; i++) {
            for (int[] edge: edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {

                    if (i == V - 1) {
                        System.out.println("Neg cycle");
                        break;
                    }

                    dist[v] = dist[u] + wt;
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    private static void dijkstras() {
        List<List<List<Integer>>> adj = buildAdjListWeighted();
        boolean[] vis = new boolean[adj.size()];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        int[] ans = new int[adj.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int src = 0;

        pq.add(new Pair(src, 0));
        ans[src] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int parentVertex = curr.first;
            int parentWt = curr.second;

            if (vis[parentVertex]) {
                continue;
            }

            vis[parentVertex] = true;

            for (List<Integer> neighbors: adj.get(parentVertex)) {
                int neighborVertex = neighbors.get(0);
                int neighborWt = neighbors.get(1);

                if (ans[parentVertex] + neighborWt < ans[neighborVertex]) {
                    ans[neighborVertex] = ans[parentVertex] + neighborWt;
                    pq.add(new Pair(neighborVertex, ans[neighborVertex]));
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    private static void prims() {
        List<List<List<Integer>>> adj = buildAdjListWeighted();
        boolean[] vis = new boolean[adj.size()];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        pq.add(new Pair(0, 0));


        int ans = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int v = curr.first;
            int wt = curr.second;

            if (vis[v]) {
                continue;
            }
            ans += wt;
            vis[v] = true;

            for (List<Integer> neighbors: adj.get(v)) {
                int vNeighbor = neighbors.get(0);
                int wNeighbor = neighbors.get(1);
                if (!vis[vNeighbor]) {
                    pq.add(new Pair(vNeighbor, wNeighbor));
                }
            }
        }
        System.out.println(ans);
    }

    private static void topoLogicalSortBFS() {
        List<List<Integer>> adj = buildAdjListDirected();
        int[] inDeg = new int[adj.size()];
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> l1: adj) {
            for (int val: l1) {
                inDeg[val] += 1;
            }
        }

        topoBfs(adj, inDeg ,ans);

        System.out.println(ans);
    }

    private static void topoBfs(List<List<Integer>> adj, int[] inDeg, List<Integer> ans) {

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            for (int neighbor: adj.get(curr)) {
                inDeg[neighbor] -= 1;
                if (inDeg[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

    }

    private static void topoLogicalSortDFS() {
        List<List<Integer>> adj = buildAdjListDirected();
        boolean[] vis = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!vis[i]) {
                topoDfs(adj, vis, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void topoDfs(List<List<Integer>> adj, boolean[] vis, int src, Stack<Integer> stack) {
        vis[src] = true;

        for (int neighbor: adj.get(src)) {
            if (!vis[neighbor]) {
                topoDfs(adj, vis, neighbor, stack);
            }
        }
        stack.push(src);
    }

    private static void bfs() {
        List<List<Integer>> adj = buildAdjList();
        boolean[] vis = new boolean[adj.size()];
        for (int i = 1; i < adj.size(); i++) {
            if (!vis[i]) {
                bfs(adj, vis, i);
            }
        }
    }

    private static void bfs(List<List<Integer>> adj, boolean[] vis, int src) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int neighbor: adj.get(curr)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    private static void dfs() {
        List<List<Integer>> adj = buildAdjList();
        boolean[] vis = new boolean[adj.size()];
        for (int i = 1; i < adj.size(); i++) {
            if (!vis[i]) {
                dfs(adj, vis, i);
            }
        }
    }

    private static void dfs(List<List<Integer>> adj, boolean[] vis, int src) {

        System.out.print(src + " ");
        vis[src] = true;

        for (int neighbor: adj.get(src)) {
            if (!vis[neighbor]) {
                dfs(adj, vis, neighbor);
            }
        }
    }

    private static List<List<Integer>> buildAdjList() {
        int v = 6; // 0 1 2 3 4 5
        List<List<Integer>> list = new ArrayList<>(6);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        AdjacencyListRep.addEdge(list, 3, 5);
        AdjacencyListRep.addEdge(list, 5, 4);
        AdjacencyListRep.addEdge(list, 5, 1);
        AdjacencyListRep.addEdge(list, 4, 1);
        AdjacencyListRep.addEdge(list, 4, 2);
        AdjacencyListRep.addEdge(list, 1, 2);

        System.out.println("***************************************\n");
        GraphUtil.displayAdjacencyList(list);
        System.out.println("***************************************\n");
        return list;
    }

    private static List<List<Integer>> buildAdjListDirected() {
        int V = 6;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        AdjacencyListRep.addEdgeDirected(list, 3, 5);
        AdjacencyListRep.addEdgeDirected(list, 5, 4);
        AdjacencyListRep.addEdgeDirected(list, 5, 1);
        AdjacencyListRep.addEdgeDirected(list, 1, 4);
        AdjacencyListRep.addEdgeDirected(list, 1, 2);
        AdjacencyListRep.addEdgeDirected(list, 0, 1);
        AdjacencyListRep.addEdgeDirected(list, 2, 4);

        System.out.println("***************************************\n");
        GraphUtil.displayAdjacencyList(list);
        System.out.println("***************************************\n");
        return list;
    }

    private static List<List<List<Integer>>> buildAdjListWeighted() {
        int V = 5;
        List<List<List<Integer>>> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        AdjacencyListRep.addEdgeWeighted(list, 0, 1, 2);
        AdjacencyListRep.addEdgeWeighted(list, 0, 4, 6);
        AdjacencyListRep.addEdgeWeighted(list, 0, 3, 7);
        AdjacencyListRep.addEdgeWeighted(list, 1, 4, 4);
        AdjacencyListRep.addEdgeWeighted(list, 1, 2, 1);
        AdjacencyListRep.addEdgeWeighted(list, 2, 4, 2);
        AdjacencyListRep.addEdgeWeighted(list, 2, 3, 3);
        AdjacencyListRep.addEdgeWeighted(list, 3, 4, 5);

        System.out.println("***************************************\n");
        GraphUtil.displayAdjacencyListWeighted(list);
        System.out.println("***************************************\n");
        return list;
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
