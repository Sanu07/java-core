package com.leetcode.assessment.jun7;

import java.util.ArrayDeque;
import java.util.Queue;

public class CodingGame {

    public static void main(String[] args) {
        char[][] grid = {
                {'*', '*', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'c', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'o', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '*', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'd', '*', '*', 'i', '*', '*', 'n', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '*', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'e', '.', '.', '.', '.', '.', 'g', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'm', '.', '.', '.', '.', '.', '*', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'a', '.', '.', '.', '.', '.', 'g', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '*', '*', '*', '*', '*', '*', '*', '.', '.', '.', '.', '.', '.'}
        };
        bfs(grid, 0, 0);
    }

    public static void bfs(char[][] grid, int r, int c) {

        int[] dirR = {-1, 0, 1, 0};
        int[] dirC = {0, 1, 0, -1};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        StringBuilder res = new StringBuilder();
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        vis[r][c] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int newR = curr[0] + dirR[i];
                int newC = curr[1] + dirC[i];
                if (isSafe(grid, newR, newC, vis)) {
                    if (Character.isLowerCase(grid[newR][newC])) {
                        res.append(grid[newR][newC]);
                    }
                    q.add(new int[] {newR, newC});
                    vis[newR][newC] = true;
                }
            }
        }
        System.out.println(res);
    }

    private static boolean isSafe(char[][] grid, int r, int c, boolean[][] vis) {
        return r >= 0 && r < grid.length &&
                c >= 0 && c < grid[0].length &&
                ((grid[r][c] == '*' || Character.isLowerCase(grid[r][c])) && !vis[r][c]);
    }
}
