package com.leetcode.problems;

public class UglNumber264 {
    public static void main(String[] args) {
        int nthUglyNumber = new UglNumber264().nthUglyNumber(1);
        System.out.println(nthUglyNumber);
    }
    public int nthUglyNumber(int n) {
        int count = 0;
        int num = 1;
        while (true) {
            if (isUgly(num)) {
                count++;
                if (count == n) {
                    return num;
                }
            }
            num++;
        }
    }

    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }

        int temp = n;
        while (temp % 2 == 0) {
            temp = temp / 2;
        }
        while (temp % 3 == 0) {
            temp = temp / 3;
        }
        while (temp % 5 == 0) {
            temp = temp / 5;
        }
        return temp == 1;
    }
}
