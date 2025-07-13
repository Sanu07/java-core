package com.leetcode.seventyfive;

import com.graph.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class RotatingOranges994 {

    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1}, {1, 1, 1}, {0, 1, 2}};
        int time = orangesRotting(grid);
        System.out.println(time);
    }

    public static int orangesRotting(int[][] grid) {
        int time = 0, fresh = 0;
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                int top = p.r - 1;
                int right = p.c + 1;
                int left = p.c - 1;
                int down = p.r + 1;
                if (top >= 0 && grid[top][p.c] == 1) {
                    grid[top][p.c] = 2;
                    q.add(new Pair(top, p.c));
                    fresh--;
                }
                if (right < grid[0].length && grid[p.r][right] == 1) {
                    grid[p.r][right] = 2;
                    q.add(new Pair(p.r, right));
                    fresh--;
                }
                if (left >= 0 && grid[p.r][left] == 1) {
                    grid[p.r][left] = 2;
                    q.add(new Pair(p.r, left));
                    fresh--;
                }
                if (down < grid.length && grid[down][p.c] == 1) {
                    grid[down][p.c] = 2;
                    q.add(new Pair(down, p.c));
                    fresh--;
                }
            }
            time += 1;
        }

        return fresh == 0 ? time : -1;
    }

    private static class Pair {
        public int r;
        public int c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
