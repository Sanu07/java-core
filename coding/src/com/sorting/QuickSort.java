package com.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // int[] arr = new int[] {1, 4, 2, 6, 3, 7, 5};5,2,3,1
        int[] arr = new int[] {5, 2, 3, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr,pivot + 1, r);
        }
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l + 1;
        int j = r;
        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
