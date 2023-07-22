package com.pdf.problems;

import java.util.*;

public class P13TwoSumAddFind {

    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        add(2);
        add(7);
        add(11);
        add(15);
        find(27);
        find(9);
    }

    private static void add(int value) {
        list.add(value);
    }

    private static void find(int value) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : list) {
            if (set.contains(value - integer)) {
                System.out.println(true);
                return;
            } else {
                set.add(integer);
            }
        }
        System.out.println(false);
    }
}
