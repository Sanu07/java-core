package com.neetcode150.slidingwindow;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,2,4,3};
        int[] nums2 = {1,4,4};
        int[] nums3 = {1,1,1,1,1,1,1,1};
        MinSizeSubArraySum minSizeSubArraySum = new MinSizeSubArraySum();
        int res = minSizeSubArraySum.minSubArrayLen(4, nums2);
        System.out.println(res);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (r < nums.length && l < nums.length) {
            sum += nums[r];
            while (sum >= target && l < nums.length) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
