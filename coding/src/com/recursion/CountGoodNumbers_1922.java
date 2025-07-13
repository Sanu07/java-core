package com.recursion;

public class CountGoodNumbers_1922 {

    public static void main(String[] args) {
        CountGoodNumbers_1922 countGoodNumbers = new CountGoodNumbers_1922();
        long n = 4; // Example input
        int result = countGoodNumbers.countGoodNumbers(n);
        System.out.println("Count of good numbers: " + result);
        System.out.println("Count of good numbers: " + (result % 1_000_000_007L));
    }

    public int countGoodNumbers(long n) {
        long lowerLimit = (long) Math.pow(10, n - 1) - 1L;
        long upperLimit = ((long) Math.pow(10, n)) - 1L;
        int count = 0;
        for (long i = lowerLimit; i <= upperLimit; i++) {
            int c = f(i, (int) n);
            if (c == 1) {
                System.out.println("Good number: " + i);
            }
            count += c;
        }
        return count;
    }

    private int f(long n, long size) {
        if (n == 0) {
            return size == 1 ? 1 : 0;
        }
        int count = 0;
        if (isTrue(n % 10, size - 1)) {
            count = 1 + f(n / 10, size - 1);
        } else {
            count = f(n / 10, size - 1);
        }
        return count;
    }

    private boolean isTrue(long n, long size) {
        if (size % 2 == 0) {
            return n % 2 == 0;
        } else {
            return isPrime(n);
        }
    }

    private boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
