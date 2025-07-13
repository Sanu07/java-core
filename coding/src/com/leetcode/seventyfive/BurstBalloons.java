package com.leetcode.seventyfive;

import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {
    public static void main(String[] args) {
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points3 = {{1,2},{2,3},{3,4},{4,5}};
        int res = findMinArrowShots(points3);
        System.out.println(res);
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(points));
        int count = 1;
        int[] curr = points[0];
        for (int i = 1; i < points.length; i++) {
            if (curr[1] >= points[i][0]) {
                if (curr[1] >= points[i][1]) {
                    curr = points[i];
                }
            } else {
                count += 1;
                curr = points[i];
            }
        }
        return count;

    }
}
