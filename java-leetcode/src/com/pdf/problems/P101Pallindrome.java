package com.pdf.problems;

public class P101Pallindrome {
    public static void main(String[] args) {
        int x = 14491;

        int temp = x;
        int result = 0;
        while (temp != 0) {
            int rem = temp % 10;
            result = result * 10 + rem;
            temp = temp / 10;
        }
        if (result == x) {
            System.out.println("Pallindrome");
        } else {
            System.out.println("Not Pallindrome");
        }
    }
}
