package com.graph;

import java.util.ArrayList;
import java.util.List;

import static com.graph.GraphUtil.displayAdjacencyList;


/**
 *     3----------5
 *             /  |
 *         /      |
 *      /         |
 *    4-----------1
 *    \           |
 *       \        |
 *          \     |
 *             \  |
 *                2
 */
public class AdjacencyListRep {

    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adjacencyList = new ArrayList<>(6);
        for (int i = 0; i <= v; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        addEdge(adjacencyList, 3, 5);
        addEdge(adjacencyList, 5, 4);
        addEdge(adjacencyList, 5, 1);
        addEdge(adjacencyList, 4, 1);
        addEdge(adjacencyList, 4, 2);
        addEdge(adjacencyList, 1, 2);

        displayAdjacencyList(adjacencyList);
    }

    public static void addEdge(List<List<Integer>> adjacencyList, int src, int dest) {
        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src);
    }

    public static void addEdgeDirected(List<List<Integer>> adjacencyList, int src, int dest) {
        adjacencyList.get(src).add(dest);
    }

    public static void addEdgeWeighted(List<List<List<Integer>>> adjacencyList, int src, int dest, int weight) {

        List<Integer> srcToDest = new ArrayList<>();
        srcToDest.add(src);
        srcToDest.add(weight);

        List<Integer> destToSrc = new ArrayList<>();
        destToSrc.add(dest);
        destToSrc.add(weight);

        adjacencyList.get(dest).add(srcToDest);
        adjacencyList.get(src).add(destToSrc);
    }
}
