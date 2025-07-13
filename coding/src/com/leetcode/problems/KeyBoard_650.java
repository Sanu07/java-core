package com.leetcode.problems;

public class KeyBoard_650 {

    public static void main(String[] args) {
        KeyBoard_650 keyBoard650 = new KeyBoard_650();
        int steps = keyBoard650.steps(4);
        System.out.println(steps);
    }

    private int steps(int n) {
       int steps = 0;
       int i = 2;
       while (n > 1) {
           while (n % i == 0) {
               steps += i;
               n = n / i;
           }
           i++;
       }
       return steps;
    }
}
