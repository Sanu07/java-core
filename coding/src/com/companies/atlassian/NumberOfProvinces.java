package com.companies.atlassian;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(adjList, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int src) {
        visited[src] = true;
        for (int neighbor: adjList.get(src)) {
            if (!visited[neighbor]) {
                dfs(adjList, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
    }
}
