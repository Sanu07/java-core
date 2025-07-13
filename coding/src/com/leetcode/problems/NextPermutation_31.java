package com.leetcode.problems;

import java.util.Arrays;

public class NextPermutation_31 {

    public static void main(String[] args) {
        NextPermutation_31 nextPermutation31 = new NextPermutation_31();
        // int[] nums = {1, 2, 3};
        // int[] nums = {3, 2, 1};
        int[] nums = {5,4,7,5,3,2};
        // int[] nums = {2, 4, 1, 7, 5, 0};
        nextPermutation31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int r = nums.length - 2;
        while (r >= 0 && nums[r] >= nums[r + 1]) {
            r--;
        }

        // If r is not -1, find the largest index nextBigger such that nums[r] < nums[nextBigger]
        if (r >= 0) {
            int nextBigger = nums.length - 1;
            while (nums[nextBigger] <= nums[r]) {
                nextBigger--;
            }
            swap(nums, r, nextBigger);
        }

        reverse(nums, r + 1);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
