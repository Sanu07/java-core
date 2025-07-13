package com.practice;

import com.graph.Pair;

import java.util.*;

public class Anything {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);
        // check2();
        // check3();
        // maximalSquare();
        // check4();

        check5();
    }

    private static void check5() {
        List<Integer> list = Arrays.asList(1, 1, 3, 3, 5, 5, 5);

        list.stream().mapToInt(Integer::intValue).toArray();

        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.second == b.second) {
                return a.first - b.first;
            } else {
                return b.first - a.first;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                int newVal = map.get(list.get(i)) + 1;
                map.put(list.get(i), newVal);
            } else {
                map.put(list.get(i), 1);
            }
        }

       for (Map.Entry<Integer, Integer> map2: map.entrySet()) {
           pq.add(new Pair(map2.getKey(), map2.getValue()));
       }

        List<Integer> ans = List.of(pq.poll().first, pq.poll().first);

        System.out.println(ans);
    }

    private static void check4() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);

        pq.remove(2);
        System.out.println(pq.peek());
    }

    private static void check3() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

    }

    private static void check2() {
        Double price = new Anything().getPrice();
        System.out.println(price);
    }

    private Double getPrice() {
        Double price = 1.0D;
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add(null);
        List<String> list1 = list.stream().map(String::toUpperCase).toList();
        System.out.println(list1);
        return Optional.of(get1(price))
                .map(this::get2)
                .map(this::get3)
                .orElse(0D);
    }

    private Double get1(Double price) {
        return price * 2D;
    }

    private Double get2(Double price) {
        // return price * 2D;
        return null;
    }

    private Double get3(Double price) {
        return price * 2D;
    }

    private static void printComb(int length, int size, int start, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == size) {
            System.out.println(temp);
            res.add(new ArrayList<>(temp));
        }

        for (int i = start; i < length; i++) {
            temp.add(i);
            printComb(length, size, i + 1, res, temp);
            // backtracking
            temp.remove(temp.size() - 1);
        }
    }

    private static void printCombStr(String str, int idx, String temp) {
        if (temp.length() == 2) {
            System.out.println(temp);
        }

        for (int i = idx; i < str.length(); i++) {
            temp += str.charAt(i);
            printCombStr(str, i + 1, temp);
            // backtracking
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void maximalSquare() {
        char[][] ch = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int maximalSquare = maximalSquare(ch);
        System.out.println(maximalSquare);
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
