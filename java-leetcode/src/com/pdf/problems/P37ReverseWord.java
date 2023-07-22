package com.pdf.problems;

public class P37ReverseWord {
    public static void main(String[] args) {
        String s = "the sky is blue";
        if (s.isEmpty()) {
            System.out.println(s);
            return;
        }
        final String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        final String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
    }
}
