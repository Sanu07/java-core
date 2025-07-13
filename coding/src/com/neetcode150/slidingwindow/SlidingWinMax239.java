package com.neetcode150.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWinMax239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        // O/P -> [3,3,5,5,6,7]
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            if (!q.isEmpty() && q.peekLast() - q.peekFirst() + 1 >= k) {
                q.pollFirst();
            }

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.add(i);

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
