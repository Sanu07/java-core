package com.leetcode.seventyfive;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76, 73};
        int[] res = new int[temp.length];
        dailyTemperatures(temp);
    }

    private static int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(results));
        return results;
    }
}
