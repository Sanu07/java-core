package com.graph;

import java.util.List;

public class GraphUtil {

    public static void displayAdjacencyMatrix(int[][] matrix) {
        int size = 6; // Matrix size (0-5)

        System.out.print("   "); // space for row index
        for (int j = 0; j < size; j++) {
            System.out.print(" " + j + "  "); // Print column indices
        }
        System.out.println();

        // Printing the adjacency matrix
        for (int i = 0; i < size; i++) {
            // Print row index
            System.out.print(i + " |");

            // Print the matrix values for each row
            for (int j = 0; j < size; j++) {
                System.out.print(" " + matrix[i][j] + "  "); // Print matrix value
            }

            System.out.println(); // Move to the next line after printing each row
        }
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
