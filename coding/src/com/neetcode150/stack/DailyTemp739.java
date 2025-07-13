package com.neetcode150.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemp739 {

    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        int[] res = new DailyTemp739().dailyTemperatures(nums);
        System.out.println(Arrays.toString(res));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
