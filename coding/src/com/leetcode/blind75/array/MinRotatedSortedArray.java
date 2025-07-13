package com.leetcode.blind75.array;

public class MinRotatedSortedArray {

    public static void main(String[] args) {
        MinRotatedSortedArray minRotatedSortedArray = new MinRotatedSortedArray();
        int[] arr = {3,4,5,1,2};
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int min = minRotatedSortedArray.findMin(arr);
        System.out.println(min);
        int max = minRotatedSortedArray.findMax(arr);
        System.out.println(max);

        int searchRotatedArray = minRotatedSortedArray.searchRotatedArray(arr, 3);
        System.out.println(searchRotatedArray);
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int findMax(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int binarySearch(int nums[], int l, int r, int target) {
        if (l <= r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return binarySearch(nums, l, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, r, target);
            }
        }
        return -1;
    }

    public int searchRotatedArray(int[] nums, int target) {
        int minIndex = findMin(nums);
        if (nums[minIndex] == target) {
            return minIndex;
        }
        if (target > nums[minIndex] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, minIndex + 1, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, minIndex - 1, target);
        }
    }
}
