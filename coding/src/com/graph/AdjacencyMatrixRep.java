package com.graph;

import static com.graph.GraphUtil.displayAdjacencyMatrix;

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
public class AdjacencyMatrixRep {

    public static void main(String[] args) {
        int v = 5;
        int[][] matrix = new int[v + 1][v + 1];
        addEdge(matrix, 3, 5);
        addEdge(matrix, 5, 4);
        addEdge(matrix, 5, 1);
        addEdge(matrix, 4, 1);
        addEdge(matrix, 4, 2);
        addEdge(matrix, 1, 2);
        displayAdjacencyMatrix(matrix);
    }

    public static void addEdge(int[][] matrix, int src, int dest) {
        matrix[src][dest] = 1;
        matrix[dest][src] = 1;
    }
}
