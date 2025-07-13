package com.leetcode.seventyfive;

public class MaxConsecutiveOne1004 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int longestOnes = longestOnes(nums1, 2);
        System.out.println(longestOnes);
    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int r = 0; r < nums.length; r++) {

            if (nums[r] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            max = Math.max(max, (r - l + 1));
        }
        return max;
    }
}
