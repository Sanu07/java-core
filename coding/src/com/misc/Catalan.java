package com.misc;

public class Catalan {

    public static void main(String[] args) {
        int catalan = catalan(3);
        System.out.println(catalan);
    }

    // C0-Cn-1 ----> Cn-1-C0
    public static int catalan(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - i - 1);
        }
        return res;
    }
}
