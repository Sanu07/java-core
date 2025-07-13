package com.leetcode.seventyfive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSubsequenceScore {

    public static void main(String[] args) {
        int[] nums1 = {2,1,14,12};
        int[] nums2 = {11,7,13,6};
        int k = 3;
        long maxScore = maxScore(nums1, nums2, k);
        System.out.println(maxScore);
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));
        System.out.println(Arrays.deepToString(pairs));
        // [[2, 4], [3, 3], [1, 2], [3, 1]]
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long max = 0;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += pairs[i][0];
            pq.add(pairs[i][0]);
        }
        max = sum * pairs[k - 1][1];
        for (int i = k; i < pairs.length; i++) {
            Integer minNum = pq.poll();
            sum = sum - minNum + pairs[i][0];
            pq.add(pairs[i][0]);
            if (sum * pairs[i][1] > max) {
                max = sum * pairs[i][1];
            }
        }
        return max;
    }
}
