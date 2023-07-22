package com.pdf.problems;

import java.util.Stack;

public class P2ReversePolishNotation {

    public static void main(String[] args) {
        String[] str1 = {"2", "1", "+", "3", "*"}; // ((2 + 1) * 3) -> 9
        String[] str2 = {"4", "13", "5", "/", "+"}; // (4 + (13 / 5)) -> 6
        reversePolishNotation(str2);
    }

    private static void reversePolishNotation(String[] str) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String s: str) {
            if (operators.contains(s)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int index = operators.indexOf(s);
                switch (index) {
                    case 0 -> stack.push(String.valueOf(a + b));
                    case 1 -> stack.push(String.valueOf(b - a));
                    case 2 -> stack.push(String.valueOf(a * b));
                    case 3 -> stack.push(String.valueOf(b / a));
                }
            } else {
                stack.push(s);
            }
        }
        System.out.println(stack.pop());
    }
}
