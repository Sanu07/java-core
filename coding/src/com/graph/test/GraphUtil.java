package com.graph.test;

import java.util.ArrayList;
import java.util.List;

public class GraphUtil {

    public static void main(String[] args) {
        // getUndirectedGraph();
        // getDirectedCyclicGraph();
        getDirectedAcyclicGraph();
    }

    /**
     * 0 ---> []
     * 1 ---> [2, 4]
     * 2 ---> [1, 3]
     * 3 ---> [2, 4, 5]
     * 4 ---> [1, 3]
     * 5 ---> [3, 6, 7]
     * 6 ---> [5]
     * 7 ---> [5]
     * @return
     */
    public static List<List<Integer>> getUndirectedGraph() {
        int V = 7;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        undirected(adjList, 1, 2);
        undirected(adjList, 1, 4);
        undirected(adjList, 2, 3);
        undirected(adjList, 3, 4);
        undirected(adjList, 3, 5);
        undirected(adjList, 5, 6);
        undirected(adjList, 5, 7);
        displayAdjacencyList(adjList);
        System.out.println("****************************************");
        return adjList;
    }

    /**
     * 0 ---> []
     * 1 ---> [2]
     * 2 ---> [3]
     * 3 ---> [4, 5]
     * 4 ---> [1]
     * 5 ---> [6, 7]
     * 6 ---> []
     * 7 ---> []
     * @return
     */
    public static List<List<Integer>> getDirectedCyclicGraph() {
        int V = 7;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        directed(adjList, 1, 2);
        directed(adjList, 2, 3);
        directed(adjList, 3, 4);
        directed(adjList, 3, 5);
        directed(adjList, 4, 1);
        directed(adjList, 5, 6);
        directed(adjList, 5, 7);
        displayAdjacencyList(adjList);
        return adjList;
    }

    /**
     * 0 ---> []
     * 1 ---> [2, 4]
     * 2 ---> [3]
     * 3 ---> [5]
     * 4 ---> [3]
     * 5 ---> [6, 7]
     * 6 ---> []
     * 7 ---> []
     * @return
     */
    public static List<List<Integer>> getDirectedAcyclicGraph() {
        int V = 7;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        directed(adjList, 1, 2);
        directed(adjList, 1, 4);
        directed(adjList, 2, 3);
        directed(adjList, 4, 3);
        directed(adjList, 3, 5);
        directed(adjList, 5, 6);
        directed(adjList, 5, 7);
        displayAdjacencyList(adjList);
        return adjList;
    }

    private static void undirected(List<List<Integer>> adjList, int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    private static void directed(List<List<Integer>> adjList, int src, int dest) {
        adjList.get(src).add(dest);
    }

    private static void weighted(List<List<List<Integer>>> adjList, int u, int v, int wt) {
        List<Integer> uTov = new ArrayList<>();
        uTov.add(u);
        uTov.add(wt);

        List<Integer> vTou = new ArrayList<>();
        vTou.add(v);
        vTou.add(wt);

        adjList.get(u).add(vTou);
        adjList.get(v).add(uTov);
    }

    public static void displayAdjacencyList(List<List<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + " ---> ");
            System.out.println(adjacencyList.get(i));
        }
    }

    public static void displayAdjacencyListWeighted(List<List<List<Integer>>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + " ---> ");
            System.out.println(adjacencyList.get(i));
        }
    }
}
