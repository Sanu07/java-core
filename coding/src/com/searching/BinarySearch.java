package com.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findNum(arr, 4);
    }

    private static void findNum(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                index = mid;
                break;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(index);
    }
}
