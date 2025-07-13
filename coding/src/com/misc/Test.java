package com.misc;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        // listToArr();
        sort();
    }

    private static void sort() {
        int[] queries = {1, 4, 2, 5};
        Integer[] ind = {0, 1, 2, 3};
        Arrays.sort(ind);
        Arrays.sort(queries);
        System.out.println(Arrays.toString(ind));
    }


    private static void listToArr() {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(1, 1));
        list.add(new Pair(2, 2));
        list.add(new Pair(3, 3));

        Pair[] array = list.toArray(new Pair[0]);
        int[][] arr = {
                {1, 1},
                {2, 2},
                {3, 3}
        };

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<int[]> list1 = Arrays.asList(arr);
        int[][] array1 = list1.toArray(new int[0][]);
        System.out.println(Arrays.deepToString(array1));

        System.out.println("**** map *****");
        Map<String, Integer> map1 = Map.of("A", 15, "D", 7, "C", 8, "B", 7,
                "Z", 7, "X", 7, "M", 7);
        LinkedHashMap<String, Integer> collect = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(collect);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
