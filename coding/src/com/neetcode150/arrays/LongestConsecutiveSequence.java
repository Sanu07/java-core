package com.neetcode150.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int res = new LongestConsecutiveSequence().longestConsecutive(nums);
        System.out.println(res);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            if (set.contains(num) && !set.contains(num - 1)) {
                while (set.contains(num)) {
                    set.remove(num);
                    count++;
                    num++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
