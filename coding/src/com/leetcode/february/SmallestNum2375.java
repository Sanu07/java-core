package com.leetcode.february;

import java.util.*;

public class SmallestNum2375 {

    public static void main(String[] args) {
        SmallestNum2375 smallestNum2375 = new SmallestNum2375();
        List<String> inputs = Arrays.asList("IIIDIDDD", "DDD", "DDDIII");
        for (String input: inputs) {
            String res = smallestNum2375.smallestNumber(input);
            System.out.println(res);
        }

    }

    public String smallestNumber(String pattern) {
       int[] res = new int[pattern.length() + 1];
       for (int i = 0; i < pattern.length() + 1; i++) {
           res[i] = (i + 1);
       }
       for (int i = 0; i < pattern.length(); i++) {
           int dIndex = i;

           while (dIndex < pattern.length() && pattern.charAt(dIndex) == 'D') {
               dIndex++;
           }

           reverse(res, i, dIndex);

           if (dIndex != i) {
               i = dIndex - 1;
           }
       }

       return Arrays.toString(res);
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
