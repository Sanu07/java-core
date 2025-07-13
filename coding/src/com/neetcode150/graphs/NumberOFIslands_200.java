package com.neetcode150.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumberOFIslands_200 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        NumberOFIslands_200 numberOFIslands200 = new NumberOFIslands_200();
        int res = numberOFIslands200.numIslands(grid);
        System.out.println(res);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int r, int c) {

        int[] dirR = {-1, 0, 1, 0};
        int[] dirC = {0, 1, 0, -1};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        grid[r][c] = '0';

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int newR = curr[0] + dirR[i];
                int newC = curr[1] + dirC[i];
                if (isSafe(grid, newR, newC)) {
                    q.add(new int[] {newR, newC});
                    grid[newR][newC] = '0';
                }
            }
        }
    }

    private static boolean isSafe(char[][] grid, int r, int c) {
        return (r < grid.length && r >= 0 && c < grid[0].length && c >= 0 && grid[r][c] == '1');
    }

    public static List<List<Integer>> adjList(char[][] grid) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    neighbors.add(j);
                }
            }
            adjList.add(neighbors);
        }
        return adjList;
    }
}
