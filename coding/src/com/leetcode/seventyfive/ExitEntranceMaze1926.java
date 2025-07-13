package com.leetcode.seventyfive;

import com.graph.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ExitEntranceMaze1926 {

    public static void main(String[] args) {
        List<char[][]> mazes = new ArrayList<>();
        mazes.add(new char[][] {{'+','+','.','+'}, {'.','.','.','+'}, {'+','+','+','.'}});
        mazes.add(new char[][] {{'+','+','+'}, {'.','.','.'}, {'+','+','+'}});
        mazes.add(new char[][] {{'.','+'}});
        char[][] maze = new char[][] {{'+','+','.','+'}, {'.','.','.','+'}, {'+','+','+','.'}};
        int[] entrance = new int[] {1, 2};
        // int exitSteps = nearestExit(maze, entrance);
        // System.out.println(nearestExit(mazes.get(0), entrance));
        System.out.println(nearestExit(mazes.get(1), new int[] {1, 0}));
        System.out.println(nearestExit(mazes.get(2), new int[] {0, 0}));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(entrance[0], entrance[1]));

        int steps = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                if (!(p.i == entrance[0] && p.j == entrance[1]) && (p.i == 0 || p.i == maze.length - 1 || p.j == 0 || p.j == maze[0].length - 1)) {
                    return steps;
                }
                int top = p.i - 1;
                int right = p.j + 1;
                int down = p.i + 1;
                int left = p.j - 1;
                if (top >= 0 && maze[top][p.j] == '.') {
                    q.add(new Pair(top, p.j));
                }
                if (right < maze[0].length && maze[p.i][right] == '.') {
                    q.add(new Pair(p.i, right));
                }
                if (down < maze.length && maze[down][p.j] == '.') {
                    q.add(new Pair(down, p.j));
                }
                if (left >= 0 && maze[p.i][left] == '.') {
                    q.add(new Pair(p.i, left));
                }
                maze[p.i][p.j] = '+';
            }
                steps++;
        }
        return -1;
    }

    private static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
