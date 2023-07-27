package com.medium.array;

import java.util.Arrays;

/**
 * Given an integer array, find the maximum product of two integers in it.
 *
 * For example, consider array {-10, -3, 5, 6, -2}. The maximum product is the (-10, -3) or (5, 6) pair.
 */
public class M8MaxProductOf2Int {
    public static void main(String[] args) {
        int[] arr = {-10, -3, 5, 6, -2};
        int[] result = max2Integers(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] max2Integers(int[] arr) {
        int largest = Math.max(arr[0], arr[1]);
        int secondMinimum = largest;
        int secondLargest = Math.min(arr[0], arr[1]);
        int minimum = secondLargest;

        for (int i = 2; i < arr.length; i++) {
            secondLargest = Math.max(secondLargest, Math.min(largest, arr[i]));
            largest = Math.max(arr[i], largest);

            secondMinimum = Math.min(Math.max(minimum, arr[i]), secondMinimum);
            minimum = Math.min(arr[i], minimum);
        }
        if (largest * secondLargest > minimum * secondMinimum) {
            return new int[] { largest, secondLargest };
        } else {
            return new int[] { minimum, secondMinimum };
        }
    }
}
